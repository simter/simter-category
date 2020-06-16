package tech.simter.category.impl.service

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.test.test
import tech.simter.category.OPERATION_READ
import tech.simter.category.core.Category
import tech.simter.category.core.Category.Status.Enabled
import tech.simter.category.core.CategoryDao
import tech.simter.category.core.CategoryService
import tech.simter.reactive.security.ModuleAuthorizer
import tech.simter.reactive.security.ReactiveSecurityService

@SpringJUnitConfig(ModuleConfiguration::class)
@MockkBean(CategoryDao::class, ModuleAuthorizer::class, ReactiveSecurityService::class)
class CategoryServiceImplTest @Autowired constructor(
  private val moduleAuthorizer: ModuleAuthorizer,
  private val dao: CategoryDao,
  private val service: CategoryService
) {
  @Test
  fun findChild() {
    // mock
    val parentParentId = 1
    val parentSNs = arrayOf("Sn")
    val childStatuses = arrayOf(Enabled)
    val expected = mockk<Category>()
    every { dao.findChild(parentParentId, parentSNs, childStatuses) } returns Flux.just(expected)
    every { moduleAuthorizer.verifyHasPermission(OPERATION_READ) } returns Mono.empty()

    // invoke and verify
    service.findChild(parentParentId, parentSNs, childStatuses)
      .test()
      .expectNext(expected)
      .verifyComplete()
    verify(exactly = 1) {
      moduleAuthorizer.verifyHasPermission(OPERATION_READ)
      dao.findChild(parentParentId, parentSNs, childStatuses)
    }
  }
}