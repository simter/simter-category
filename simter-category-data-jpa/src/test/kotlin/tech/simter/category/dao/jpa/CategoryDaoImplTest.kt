package tech.simter.category.dao.jpa

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import tech.simter.category.dao.CategoryDao
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * @author RJ
 */
@SpringJUnitConfig(ModuleConfiguration::class)
@DataJpaTest
class CategoryDaoImplTest @Autowired constructor(
  @PersistenceContext val em: EntityManager,
  val dao: CategoryDao
)