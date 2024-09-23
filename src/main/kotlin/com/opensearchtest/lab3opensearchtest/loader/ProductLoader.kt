package com.opensearchtest.lab3opensearchtest.loader

import com.opensearchtest.lab3opensearchtest.config.OpenSearchConfig
import com.opensearchtest.lab3opensearchtest.models.Product
import com.opensearchtest.lab3opensearchtest.repositories.jparepository.ProductRepository
import jakarta.annotation.PostConstruct
import net.datafaker.Faker
import org.opensearch.client.opensearch.core.IndexRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class ProductLoader(
    @Autowired private val productRepository: ProductRepository,
    @Autowired private val openSearchConfig: OpenSearchConfig,
) {
    private val faker = Faker() // Create a DataFaker instance

    // Load products after the application starts
    @PostConstruct
    fun loadProductsIfEmpty() {
        if (productRepository.count() == 0L) {
            val products = generateRandomProducts(10)
            productRepository.saveAll(products) // Save to Postgres (JPA)

            // Index products in OpenSearch
            products.forEach { product ->
                indexProductInOpenSearch(product) // Index each product
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

    // Function to index a product in OpenSearch
    private fun indexProductInOpenSearch(product: Product) {
        val openSearchClient = openSearchConfig.openSearchClient() // Get the OpenSearch client
        val indexRequest =
            IndexRequest.Builder<Product>()
                .index("product") // Name of the OpenSearch index
                .id(product.id.toString()) // Use product ID as the document ID
                .document(product) // The product document
                .build()

        openSearchClient.index(indexRequest) // Index the product in OpenSearch
    }
}
