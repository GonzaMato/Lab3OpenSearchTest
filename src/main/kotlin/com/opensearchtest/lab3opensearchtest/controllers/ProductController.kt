package com.opensearchtest.lab3opensearchtest.controllers

import com.opensearchtest.lab3opensearchtest.services.interfaces.ProductSearchService
import com.opensearchtest.lab3opensearchtest.services.interfaces.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService, private val productSearchService: ProductSearchService) {
    @GetMapping("/search")
    fun searchProducts(
        @RequestParam searchParam: String,
    ): ResponseEntity<*> {
        try {
            val products = productSearchService.searchByNameAndDescriptionAndTags(searchParam)
            return ResponseEntity.ok(products)
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body("Error: ${e.message}")
        }
    }
}
