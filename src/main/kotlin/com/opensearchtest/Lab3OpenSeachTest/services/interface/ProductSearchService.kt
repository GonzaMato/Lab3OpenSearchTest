package com.opensearchtest.Lab3OpenSeachTest.services.`interface`

import com.opensearchtest.Lab3OpenSeachTest.models.Product

interface ProductSearchService {

    fun searchByNameAndDescriptionAndTags(search : String ) : List<Product>
}