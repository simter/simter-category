package tech.simter.category.impl.dao.jpa

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import tech.simter.category.core.Category
import tech.simter.category.core.Category.Status
import tech.simter.category.core.CategoryDao
import tech.simter.reactive.jpa.ReactiveJpaWrapper

/**
 * The JPA implementation of [CategoryDao].
 *
 * @author RJ
 */
@Repository
class CategoryDaoImpl @Autowired constructor(
  private val blockDao: CategoryBlockDao,
  private val wrapper: ReactiveJpaWrapper
) : CategoryDao {
  override fun findChild(parentParentId: Int, parentSNs: Array<String>, childStatuses: Array<Status>): Flux<Category> {
    return wrapper.fromIterable { blockDao.findChild(parentParentId, parentSNs, childStatuses) }
  }
}