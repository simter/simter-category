package tech.simter.category.service

import reactor.core.publisher.Flux
import tech.simter.category.po.Category

/**
 * The Service Interface.
 *
 * This interface is design for all external modules to use.
 *
 * @author RJ
 * @author JF
 */
interface CategoryService {
  /**
   * Find child categories by the parent's sn under the parent's parent's id.
   *
   * The return result order by parent's sn asc + child's status asc + child's sn asc.
   *
   * @param [parentParentId] parent id of the parent sn
   * @param [parentSNs] parent sn of the child
   * @param [childStatuses] child status
   * @return [Flux] emitting the child category if exists or [Flux.empty] otherwise
   */
  fun findChild(parentParentId: Int, parentSNs: Array<String>, childStatuses: Array<Category.Status>): Flux<Category>
}