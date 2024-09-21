package com.opensearchtest.Lab3OpenSeachTest.services.`interface`

interface ProductService {
    fun saveProduct(name : String, price : Double, description : String,  tags : MutableList<String>)
}