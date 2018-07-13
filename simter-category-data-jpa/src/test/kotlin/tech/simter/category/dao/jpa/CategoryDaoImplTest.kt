package tech.simter.category.dao.jpa

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import reactor.test.StepVerifier
import tech.simter.category.dao.CategoryDao
import tech.simter.category.po.Category
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * @author RJ
 * @author JF
 */
@SpringJUnitConfig(ModuleConfiguration::class)
@DataJpaTest
class CategoryDaoImplTest @Autowired constructor(
  @PersistenceContext val em: EntityManager,
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
    em.persist(primary)
    em.persist(parent2); em.persist(p2Child2); em.persist(p2Child1)
    em.persist(parent1); em.persist(p1Child2); em.persist(p1Child1)
    em.persist(Category(null, parent2, Category.Status.Draft, "p2-child2", "3"))
    em.flush(); em.clear()

    // invoke
    val actual = dao.findChild(primary.id!!, arrayOf("1", "2"), arrayOf(Category.Status.Enabled, Category.Status.Disabled))

    // verify
    StepVerifier.create(actual)
      .expectNext(p1Child1)
      .expectNext(p1Child2)
      .expectNext(p2Child1)
      .expectNext(p2Child2)
      .verifyComplete()
  }
}