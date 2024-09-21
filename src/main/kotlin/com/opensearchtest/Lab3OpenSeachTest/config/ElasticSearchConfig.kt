package com.opensearchtest.Lab3OpenSeachTest.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@Configuration
@EnableElasticsearchRepositories(basePackages = ["com.opensearchtest.Lab3OpenSeachTest.repositories.elasticsearch"])
class ElasticSearchConfig {
}