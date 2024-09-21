package com.opensearchtest.Lab3OpenSeachTest.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["com.opensearchtest.Lab3OpenSeachTest.repositories.jparepository"])
class JPAConfig {
}