package com.opensearchtest.lab3opensearchtest.config

import org.apache.http.HttpHost
import org.opensearch.client.RestClient
import org.opensearch.client.json.jackson.JacksonJsonpMapper
import org.opensearch.client.opensearch.OpenSearchClient
import org.opensearch.client.transport.OpenSearchTransport
import org.opensearch.client.transport.rest_client.RestClientTransport
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@Configuration
@EnableElasticsearchRepositories(basePackages = ["com.opensearchtest.lab3opensearchtest.repositories.elasticsearch"])
class OpenSearchConfig {
    @Bean
    fun openSearchClient(): OpenSearchClient {
        val restClient =
            RestClient.builder(
                HttpHost("opensearch", 9200, "http"),
            ).build()

        // Create the transport with a Jackson mapper
        val transport: OpenSearchTransport =
            RestClientTransport(
                restClient,
                JacksonJsonpMapper(),
            )

        // And create the API client
        return OpenSearchClient(transport)
    }
}
