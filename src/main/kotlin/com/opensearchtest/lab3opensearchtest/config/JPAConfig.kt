package com.opensearchtest.lab3opensearchtest.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["com.opensearchtest.lab3opensearchtest.repositories.jparepository"])
class JPAConfig
