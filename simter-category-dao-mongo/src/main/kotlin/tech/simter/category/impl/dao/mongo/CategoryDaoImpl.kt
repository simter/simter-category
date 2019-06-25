package tech.simter.category.impl.dao.mongo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import tech.simter.category.core.Category
import tech.simter.category.core.CategoryDao

/**
 * The Reactive MongoDB implementation of [CategoryDao].
 *
 * @author RJ
 */
@Repository
class CategoryDaoImpl @Autowired constructor(
  private val repository: CategoryReactiveRepository
) : CategoryDao {
  override fun findChild(parentParentId: Int, parentSNs: Array<String>, childStatuses: Array<Category.Status>)
    : Flux<Category> {
    TODO("not implemented")
  }
}