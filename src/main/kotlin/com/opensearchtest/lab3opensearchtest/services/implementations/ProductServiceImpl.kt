package com.opensearchtest.lab3opensearchtest.services.implementations

import com.opensearchtest.lab3opensearchtest.models.Product
import com.opensearchtest.lab3opensearchtest.repositories.jparepository.ProductRepository
import com.opensearchtest.lab3opensearchtest.services.interfaces.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    @Autowired private val productRepository: ProductRepository,
) : ProductService {
    override fun saveProduct(
        name: String,
        price: Double,
        description: String,
        tags: MutableList<String>,
    ): Product {
        val product = Product(name, price, description, tags)
        return productRepository.save(product)
    }
}
