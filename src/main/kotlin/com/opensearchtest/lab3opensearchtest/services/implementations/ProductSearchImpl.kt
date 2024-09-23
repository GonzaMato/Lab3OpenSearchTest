package com.opensearchtest.lab3opensearchtest.services.implementations

import com.opensearchtest.lab3opensearchtest.config.OpenSearchConfig
import com.opensearchtest.lab3opensearchtest.models.Product
import com.opensearchtest.lab3opensearchtest.services.interfaces.ProductSearchService
import org.opensearch.client.opensearch.OpenSearchClient
import org.opensearch.client.opensearch._types.query_dsl.Query
import org.opensearch.client.opensearch.core.IndexRequest
import org.opensearch.client.opensearch.core.SearchRequest
import org.opensearch.client.opensearch.core.SearchResponse
import org.opensearch.client.opensearch.core.search.Hit
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductSearchImpl(
    @Autowired private val openSearchConfig: OpenSearchConfig,
) : ProductSearchService {
    private val openSearchClient: OpenSearchClient = openSearchConfig.openSearchClient()

    override fun searchByNameAndDescriptionAndTags(search: String): List<Product> {
        // Crear la consulta multi_match sin usar QueryBuilders
        val query =
            Query.Builder()
                .multiMatch { mm ->
                    mm.query(search)
                        .fields("name", "description", "tags")
                }
                .build()

        // Crear la petición de búsqueda
        val searchRequest =
            SearchRequest.Builder()
                .index("product")
                .query(query)
                .build()

        // Ejecutar la búsqueda
        val searchResponse: SearchResponse<Product> = openSearchClient.search(searchRequest, Product::class.java)

        // Devolver los resultados
        return searchResponse.hits().hits().map(Hit<Product>::source).filterNotNull()
    }

    override fun saveProduct(product: Product): Product {
        // Guardar el producto en OpenSearch
        val indexRequest =
            org.opensearch.client.opensearch.core.IndexRequest.Builder<Product>()
                .index("product")
                .id(product.id.toString())
                .document(product)
                .build()

        openSearchClient.index(indexRequest)
        return product
    }
}
