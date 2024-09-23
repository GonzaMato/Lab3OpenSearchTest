package com.opensearchtest.lab3opensearchtest.controllers

import com.opensearchtest.lab3opensearchtest.dto.ProductDTO
import com.opensearchtest.lab3opensearchtest.services.interfaces.ProductSearchService
import com.opensearchtest.lab3opensearchtest.services.interfaces.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @PostMapping("/add")
    fun addProduct(
        @RequestBody product: ProductDTO,
    ): ResponseEntity<*> {
        try {
            val productSaved = productService.saveProduct(product.name, product.price, product.description, product.tags.toMutableList())
            productSearchService.saveProduct(productSaved)
            return ResponseEntity.ok(product)
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body("Error: ${e.message}")
        }
    }
}
