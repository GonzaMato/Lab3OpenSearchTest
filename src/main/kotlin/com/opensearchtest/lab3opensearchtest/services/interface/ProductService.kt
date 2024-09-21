package com.opensearchtest.lab3opensearchtest.services.`interface`

interface ProductService {
    fun saveProduct(
        name: String,
        price: Double,
        description: String,
        tags: MutableList<String>,
    )
}
