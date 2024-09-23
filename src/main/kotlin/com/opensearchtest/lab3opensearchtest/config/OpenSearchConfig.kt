package com.opensearchtest.lab3opensearchtest.config

import org.apache.http.HttpHost
import org.opensearch.client.RestClient
import org.opensearch.client.json.jackson.JacksonJsonpMapper
import org.opensearch.client.opensearch.OpenSearchClient
import org.opensearch.client.transport.OpenSearchTransport
import org.opensearch.client.transport.rest_client.RestClientTransport
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenSearchConfig {
    @Bean
    fun openSearchClient(): OpenSearchClient {
        val restClient =
            RestClient.builder(
                HttpHost("opensearch", 9200, "http"),
            ).build()

        val transport: OpenSearchTransport =
            RestClientTransport(
                restClient,
                JacksonJsonpMapper(),
            )

        return OpenSearchClient(transport)
    }
}
