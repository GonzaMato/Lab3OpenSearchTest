package com.opensearchtest.lab3opensearchtest.dto

data class ProductDTO(
    val name: String = "",
    val price: Double = 0.0,
    val description: String = "",
    val tags: List<String> = listOf(),
)
