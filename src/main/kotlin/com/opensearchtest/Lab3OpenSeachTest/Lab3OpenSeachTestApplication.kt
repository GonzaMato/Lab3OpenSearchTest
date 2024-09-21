package com.opensearchtest.Lab3OpenSeachTest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class Lab3OpenSeachTestApplication

fun main(args: Array<String>) {
	runApplication<Lab3OpenSeachTestApplication>(*args)
}
