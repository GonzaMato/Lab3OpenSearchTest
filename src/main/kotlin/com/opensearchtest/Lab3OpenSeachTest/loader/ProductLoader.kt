package com.opensearchtest.Lab3OpenSeachTest.loader

import com.opensearchtest.Lab3OpenSeachTest.models.Product
import com.opensearchtest.Lab3OpenSeachTest.repositories.elasticsearch.ProductSearchRepository
import com.opensearchtest.Lab3OpenSeachTest.repositories.jparepository.ProductRepository
import jakarta.annotation.PostConstruct
import net.datafaker.Faker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class ProductLoader(
    @Autowired private val productRepository: ProductRepository,  // JPA repository
    @Autowired private val productSearchRepository: ProductSearchRepository  // Elasticsearch repository
) {

    private val faker = Faker()  // Create a DataFaker instance

    // Load products after the application starts
    @PostConstruct
    fun loadProductsIfEmpty() {
        // Check if there are any products in the database
        if (productRepository.count() == 0L) {
            // Generate and save 1000 random products
            val products = generateRandomProducts(1000)
            productRepository.saveAll(products)  // Save to Postgres (JPA)
            productSearchRepository.saveAll(products)  // Index to Elasticsearch (OpenSearch)
            println("1000 products loaded into the database.")
        } else {
            println("Database already contains products. No products were loaded.")
        }
    }

    // Generate random products using DataFaker
    private fun generateRandomProducts(count: Int): List<Product> {
        val products = mutableListOf<Product>()
        for (i in 1..count) {
            val productName = faker.commerce().productName()  // Generate a random product name
            val productDescription = faker.lorem().sentence()  // Generate a random description
            val productPrice = faker.commerce().price().toDouble()  // Generate a random price
            val productTags = listOf(faker.commerce().material(), faker.commerce().department())  // Generate random tags

            val product = Product(
                name = productName,
                price = productPrice,
                description = productDescription,
                tags = productTags.toMutableList()
            )
            products.add(product)
        }
        return products
    }
}