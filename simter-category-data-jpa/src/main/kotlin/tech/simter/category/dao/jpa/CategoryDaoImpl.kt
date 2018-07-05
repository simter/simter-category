package tech.simter.category.dao.jpa

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import tech.simter.category.dao.CategoryDao
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * The JPA implementation of [CategoryDao].
 *
 * @author RJ
 */
@Component
class CategoryDaoImpl @Autowired constructor(
  @PersistenceContext private val em: EntityManager,
  private val repository: CategoryJpaRepository
) : CategoryDao