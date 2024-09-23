package com.opensearchtest.lab3opensearchtest.services.interfaces

import com.opensearchtest.lab3opensearchtest.models.Product

interface ProductSearchService {
    fun searchByNameAndDescriptionAndTags(search: String): List<Product?>

    fun saveProduct(product: Product): Product
}
