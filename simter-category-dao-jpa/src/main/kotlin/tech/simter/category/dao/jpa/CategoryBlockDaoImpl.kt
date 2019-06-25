package tech.simter.category.dao.jpa

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import tech.simter.category.po.Category
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * The JPA implementation of [CategoryBlockDao].
 *
 * @author RJ
 */
@Repository
class CategoryBlockDaoImpl @Autowired constructor(
  @PersistenceContext private val em: EntityManager
) : CategoryBlockDao {
  @Transactional(readOnly = true)
  override fun findChild(parentParentId: Int, parentSNs: Array<String>, childStatuses: Array<Category.Status>): List<Category> {
    val hql = """
      select c from Category c
      inner join Category p on p.pid.id = :pPid and p.sn in (:pSNs)
      where c.pid = p.id and c.status in (:cStatuses)
      order by p.sn asc, c.status asc, c.sn asc
      """.trimIndent()
    return em.createQuery(hql, Category::class.java)
      .setParameter("pPid", parentParentId)
      .setParameter("pSNs", parentSNs.toList())
      .setParameter("cStatuses", childStatuses.toList())
      .resultList
  }
}