package com.opensearchtest.lab3opensearchtest.services.implementations

import com.opensearchtest.lab3opensearchtest.models.Product
import com.opensearchtest.lab3opensearchtest.repositories.elasticsearch.ProductSearchRepository
import com.opensearchtest.lab3opensearchtest.repositories.jparepository.ProductRepository
import com.opensearchtest.lab3opensearchtest.services.`interface`.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    @Autowired private val productRepository: ProductRepository,
    @Autowired private val productSearchService: ProductSearchRepository,
) : ProductService {
    override fun saveProduct(
        name: String,
        price: Double,
        description: String,
        tags: MutableList<String>,
    ) {
        val product = Product(name, price, description, tags)
        val savedProduct = productRepository.save(product)

        productSearchService.save(savedProduct)
    }
}
