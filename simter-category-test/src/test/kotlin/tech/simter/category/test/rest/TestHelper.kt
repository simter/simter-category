package tech.simter.category.test.rest

import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.reactive.server.WebTestClient
import tech.simter.category.core.Category
import tech.simter.category.test.TestHelper.randomCategory

object TestHelper {
  /** create one category */
  fun createOneCategory(
    client: WebTestClient,
    category: Category = randomCategory()
  ): Category {
    client.post()
      .uri("/")
      .contentType(APPLICATION_JSON)
      .bodyValue(randomCategory())
      .exchange()
      .expectStatus().isNoContent
      .expectBody().isEmpty

    return category
  }
}