package com.opensearchtest.Lab3OpenSeachTest.services.implementations

import com.opensearchtest.Lab3OpenSeachTest.models.Product
import com.opensearchtest.Lab3OpenSeachTest.repositories.elasticsearch.ProductSearchRepository
import com.opensearchtest.Lab3OpenSeachTest.services.`interface`.ProductSearchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductSearchImpl (
    @Autowired private val productSearchRepository: ProductSearchRepository
) : ProductSearchService {

    override fun searchByNameAndDescriptionAndTags(search: String): List<Product> {
        return productSearchRepository.findByNameOrDescriptionOrTags(search)
    }
}