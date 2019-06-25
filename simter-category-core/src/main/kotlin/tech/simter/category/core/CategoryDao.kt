package tech.simter.category.core

import reactor.core.publisher.Flux

/**
 * The Dao Interface.
 *
 * This interface should only be use by [CategoryService]. It is design to public just for multiple Dao implements.
 *
 * @author RJ
 * @author JF
 */
interface CategoryDao {
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