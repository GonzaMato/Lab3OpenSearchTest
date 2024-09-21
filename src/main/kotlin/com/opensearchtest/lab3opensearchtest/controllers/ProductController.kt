package com.opensearchtest.lab3opensearchtest.controllers

import com.opensearchtest.lab3opensearchtest.services.`interface`.ProductService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val produtService: ProductService)
