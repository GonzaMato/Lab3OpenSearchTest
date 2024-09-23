package com.opensearchtest.lab3opensearchtest.loader

import com.opensearchtest.lab3opensearchtest.models.Product
import com.opensearchtest.lab3opensearchtest.repositories.elasticsearch.ProductSearchRepository
import com.opensearchtest.lab3opensearchtest.repositories.jparepository.ProductRepository
import jakarta.annotation.PostConstruct
import net.datafaker.Faker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class ProductLoader(
    @Autowired private val productRepository: ProductRepository,
    @Autowired private val productSearchRepository: ProductSearchRepository,
) {
    private val faker = Faker() // Create a DataFaker instance

    // Load products after the application starts
    @PostConstruct
    fun loadProductsIfEmpty() {
        if (productRepository.count() == 0L) {
            val products = generateRandomProducts(300)
            productRepository.saveAll(products) // Save to Postgres (JPA)

            // Index products in batches to OpenSearch
            products.chunked(100).forEach { batch ->
                productSearchRepository.saveAll(batch) // Batch indexing
            }

            println("${products.size} products loaded into the database and OpenSearch.")
        } else {
            println("Database already contains products. No products were loaded.")
        }
    }

    // Generate random products using DataFaker
    private fun generateRandomProducts(count: Int): List<Product> {
        val products = mutableListOf<Product>()
        for (i in 1..count) {
            val productName = faker.commerce().productName() // Generate a random product name
            val productDescription = faker.lorem().sentence() // Generate a random description
            val productPrice = faker.commerce().price().toDouble() // Generate a random price
            val productTags = listOf(faker.commerce().material(), faker.commerce().department()) // Generate random tags

            val product =
                Product(
                    name = productName,
                    price = productPrice,
                    description = productDescription,
                    tags = productTags.toMutableList(),
                )
            products.add(product)
        }
        return products
    }
}
