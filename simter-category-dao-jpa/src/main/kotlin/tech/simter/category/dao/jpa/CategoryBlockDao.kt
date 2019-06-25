package tech.simter.category.dao.jpa

import tech.simter.category.po.Category

/**
 * The block JPA Dao Interface.
 *
 * @author RJ
 */
interface CategoryBlockDao {
  /**
   * Find child categories by the parent's sn under the parent's parent's id.
   *
   * The return result order by parent's sn asc + child's status asc + child's sn asc.
   *
   * @param[parentParentId] parent id of the parent sn
   * @param[parentSNs] parent sn of the child
   * @param[childStatuses] child status
   * @return the child categories
   */
  fun findChild(parentParentId: Int, parentSNs: Array<String>, childStatuses: Array<Category.Status>): List<Category>
}