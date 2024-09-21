package com.opensearchtest.Lab3OpenSeachTest.models

import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Product(
    val name : String = "",
    val price : Double = 0.0,
    val description : String = "",
    @ElementCollection
    var tags: MutableList<String> = mutableListOf()
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}