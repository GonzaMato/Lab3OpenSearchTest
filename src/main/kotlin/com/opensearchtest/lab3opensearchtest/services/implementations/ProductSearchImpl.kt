package com.opensearchtest.lab3opensearchtest.services.implementations

import com.opensearchtest.lab3opensearchtest.models.Product
import com.opensearchtest.lab3opensearchtest.repositories.elasticsearch.ProductSearchRepository
import com.opensearchtest.lab3opensearchtest.services.interfaces.ProductSearchService
import org.opensearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductSearchImpl(
    @Autowired private val productSearchRepository: ProductSearchRepository,
    @Autowired private val openSearchClient: RestHighLevelClient,
) : ProductSearchService {
    override fun searchByNameAndDescriptionAndTags(search: String): List<Product> {
        return productSearchRepository.findByNameOrDescriptionOrTags(search)
    }
}
