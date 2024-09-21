package com.opensearchtest.Lab3OpenSeachTest.repositories.jparepository

import com.opensearchtest.Lab3OpenSeachTest.models.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
}