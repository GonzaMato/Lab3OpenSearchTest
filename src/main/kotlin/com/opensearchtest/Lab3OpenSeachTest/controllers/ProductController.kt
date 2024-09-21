package com.opensearchtest.Lab3OpenSeachTest.controllers

import com.opensearchtest.Lab3OpenSeachTest.services.`interface`.ProductService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController( private val produtService : ProductService) {
}