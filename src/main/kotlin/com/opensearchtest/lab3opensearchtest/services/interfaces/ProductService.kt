package com.opensearchtest.lab3opensearchtest.services.interfaces

import com.opensearchtest.lab3opensearchtest.models.Product

interface ProductService {
    fun saveProduct(
        name: String,
        price: Double,
        description: String,
        tags: MutableList<String>,
    ): Product
}
