package com.opensearchtest.lab3opensearchtest.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@Configuration
@EnableElasticsearchRepositories(basePackages = ["com.opensearchtest.lab3opensearchtest.repositories.elasticsearch"])
class ElasticSearchConfig
