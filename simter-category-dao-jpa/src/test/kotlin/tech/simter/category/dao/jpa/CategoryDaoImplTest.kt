package tech.simter.category.dao.jpa

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import reactor.test.StepVerifier
import tech.simter.category.dao.CategoryDao
import tech.simter.category.po.Category
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
    val primary = Category(null, null, Category.Status.Enabled, "primary", "0")
    val parent1 = Category(null, primary, Category.Status.Enabled, "parent1", "1")
    val p1Child1 = Category(null, parent1, Category.Status.Enabled, "p1-child1", "1")
    val p1Child2 = Category(null, parent1, Category.Status.Disabled, "p1-child2", "2")
    val parent2 = Category(null, primary, Category.Status.Enabled, "parent2", "2")
    val p2Child1 = Category(null, parent2, Category.Status.Enabled, "p2-child1", "1")
    val p2Child2 = Category(null, parent2, Category.Status.Enabled, "p2-child2", "2")
    rem.persist(
      primary, parent2, p2Child2, p2Child1, parent1, p1Child2, p1Child1,
      Category(null, parent2, Category.Status.Draft, "p2-child3", "3")
    )

    // invoke
    val actual = dao.findChild(
      parentParentId = primary.id!!,
      parentSNs = arrayOf("1", "2"),
      childStatuses = arrayOf(Category.Status.Enabled, Category.Status.Disabled)
    )

    // verify
    StepVerifier.create(actual)
      .expectNext(p1Child1)
      .expectNext(p1Child2)
      .expectNext(p2Child1)
      .expectNext(p2Child2)
      .verifyComplete()
  }
}