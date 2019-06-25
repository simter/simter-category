package tech.simter.category.impl.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import tech.simter.category.OPERATION_READ
import tech.simter.category.PACKAGE
import tech.simter.category.core.Category
import tech.simter.category.core.CategoryDao
import tech.simter.category.core.CategoryService
import tech.simter.reactive.security.ModuleAuthorizer

/**
 * The Service implementation of [CategoryService].
 *
 * @author RJ
 * @author JF
 */
@Service
class CategoryServiceImpl @Autowired constructor(
  @Qualifier("$PACKAGE.ModuleAuthorizer")
  private val moduleAuthorizer: ModuleAuthorizer,
  private val dao: CategoryDao
) : CategoryService {
  override fun findChild(parentParentId: Int, parentSNs: Array<String>, childStatuses: Array<Category.Status>): Flux<Category> {
    return moduleAuthorizer.verifyHasPermission(OPERATION_READ).thenMany(
      dao.findChild(parentParentId, parentSNs, childStatuses)
    )
  }
}