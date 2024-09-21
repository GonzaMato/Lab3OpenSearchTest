package com.opensearchtest.lab3opensearchtest.repositories.jparepository

import com.opensearchtest.lab3opensearchtest.models.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>
