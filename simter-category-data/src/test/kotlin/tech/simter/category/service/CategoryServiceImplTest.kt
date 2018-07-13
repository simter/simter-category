package tech.simter.category.service

import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import tech.simter.category.dao.CategoryDao
import tech.simter.category.po.Category

@SpringJUnitConfig(CategoryServiceImpl::class)
@MockBean(CategoryDao::class)
class CategoryServiceImplTest @Autowired constructor(
  private val dao: CategoryDao,
  private val service: CategoryService
) {
  @Test
  fun findChild() {
    // mock
    val parentParentId = 1
    val parentSNs = arrayOf("Sn")
    val childStatuses = arrayOf(Category.Status.Enabled)
    val expected = Category(null, null, Category.Status.Enabled, "primary", "Sn")
    `when`(dao.findChild(parentParentId, parentSNs, childStatuses)).thenReturn(Flux.just(expected))

    // invoke
    val actual = service.findChild(parentParentId, parentSNs, childStatuses)

    // verify
    StepVerifier.create(actual).expectNext(expected).verifyComplete()
    verify(dao).findChild(parentParentId, parentSNs, childStatuses)
  }
}