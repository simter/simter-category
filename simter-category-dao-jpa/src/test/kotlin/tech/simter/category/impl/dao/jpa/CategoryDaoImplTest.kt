package tech.simter.category.impl.dao.jpa

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import reactor.kotlin.test.test
import tech.simter.category.core.Category.Status.*
import tech.simter.category.core.CategoryDao
import tech.simter.category.impl.dao.jpa.TestHelper.randomCategoryPo
import tech.simter.reactive.test.jpa.ReactiveDataJpaTest
import tech.simter.reactive.test.jpa.TestEntityManager

/**
 * @author RJ
 */
@SpringJUnitConfig(UnitTestConfiguration::class)
@ReactiveDataJpaTest
class CategoryDaoImplTest @Autowired constructor(
  val rem: TestEntityManager,
  val dao: CategoryDao
) {
  @Test
  fun findChild() {
    // mock
    val primary = randomCategoryPo(status = Enabled, name = "primary", sn = "0")
    val parent1 = randomCategoryPo(parent = primary, status = Enabled, name = "parent1", sn = "1")
    val p1Child1 = randomCategoryPo(parent = parent1, status = Enabled, name = "p1-child1", sn = "1")
    val p1Child2 = randomCategoryPo(parent = parent1, status = Disabled, name = "p1-child2", sn = "2")
    val parent2 = randomCategoryPo(parent = primary, status = Enabled, name = "parent2", sn = "2")
    val p2Child1 = randomCategoryPo(parent = parent2, status = Enabled, name = "p2-child1", sn = "1")
    val p2Child2 = randomCategoryPo(parent = parent2, status = Enabled, name = "p2-child2", sn = "2")
    rem.persist(
      primary, parent2, p2Child2, p2Child1, parent1, p1Child2, p1Child1,
      randomCategoryPo(parent = parent2, status = Draft, name = "p2-child3", sn = "3")
    )

    // invoke and verify
    dao.findChild(
      parentParentId = primary.id!!,
      parentSNs = arrayOf("1", "2"),
      childStatuses = arrayOf(Enabled, Disabled)
    ).test()
      .expectNext(p1Child1)
      .expectNext(p1Child2)
      .expectNext(p2Child1)
      .expectNext(p2Child2)
      .verifyComplete()
  }
}