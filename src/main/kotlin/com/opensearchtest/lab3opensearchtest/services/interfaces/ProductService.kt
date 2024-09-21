package com.opensearchtest.lab3opensearchtest.services.interfaces

interface ProductService {
    fun saveProduct(
        name: String,
        price: Double,
        description: String,
        tags: MutableList<String>,
    )
}
