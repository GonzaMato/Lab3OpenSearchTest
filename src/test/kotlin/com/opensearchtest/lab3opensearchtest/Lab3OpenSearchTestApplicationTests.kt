package com.opensearchtest.lab3opensearchtest

import org.junit.jupiter.api.Test
import org.opensearch.client.RestHighLevelClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class Lab3OpenSearchTestApplicationTests {
    @MockBean
    lateinit var openSearchClient: RestHighLevelClient

    @Test
    fun contextLoads() {
    }
}
