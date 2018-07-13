package tech.simter.category.dao.reactive.mongo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import tech.simter.category.dao.CategoryDao
import tech.simter.category.po.Category

/**
 * The Reactive MongoDB implementation of [CategoryDao].
 *
 * @author RJ
 */
@Component
class CategoryDaoImpl @Autowired constructor(
  private val repository: CategoryReactiveRepository
) : CategoryDao {
  override fun findChild(parentParentId: Int, parentSNs: Array<String>, childStatuses: Array<Category.Status>): Flux<Category> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}