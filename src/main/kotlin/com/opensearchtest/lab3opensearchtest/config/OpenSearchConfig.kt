package com.opensearchtest.lab3opensearchtest.config

import org.apache.http.HttpHost
import org.opensearch.client.RestClient
import org.opensearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@Configuration
@EnableElasticsearchRepositories(basePackages = ["com.opensearchtest.lab3opensearchtest.repositories.elasticsearch"])
class OpenSearchConfig {
    @Bean
    fun restHighLevelClient(): RestHighLevelClient {
        return RestHighLevelClient(
            RestClient.builder(
                HttpHost("opensearch", 9200, "http"),
            ),
        )
    }
}
