package com.opensearchtest.lab3opensearchtest.repositories.elasticsearch

import com.opensearchtest.lab3opensearchtest.models.Product
import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface ProductSearchRepository : ElasticsearchRepository<Product, Long> {
    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"name\", \"description\", \"tags\"]}}")
    fun findByNameOrDescriptionOrTags(searchText: String): List<Product>
}
