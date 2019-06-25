package tech.simter.category.dao.jpa

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import tech.simter.category.dao.CategoryDao
import tech.simter.category.po.Category
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
  override fun findChild(parentParentId: Int, parentSNs: Array<String>, childStatuses: Array<Category.Status>): Flux<Category> {
    return wrapper.fromIterable { blockDao.findChild(parentParentId, parentSNs, childStatuses) }
  }
}