package com.opensearchtest.lab3opensearchtest.services.`interface`

import com.opensearchtest.lab3opensearchtest.models.Product

interface ProductSearchService {
    fun searchByNameAndDescriptionAndTags(search: String): List<Product>
}
