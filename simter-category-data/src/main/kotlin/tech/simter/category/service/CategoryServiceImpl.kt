package tech.simter.category.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import tech.simter.category.dao.CategoryDao
import tech.simter.category.po.Category

/**
 * The Service implementation of [CategoryService].
 *
 * @author JF
 */
@Component
@Transactional
class CategoryServiceImpl @Autowired constructor(
  private val dao: CategoryDao
) : CategoryService {
  override fun findChild(parentParentId: Int, parentSNs: Array<String>, childStatuses: Array<Category.Status>): Flux<Category> {
    return dao.findChild(parentParentId, parentSNs, childStatuses)
  }
}