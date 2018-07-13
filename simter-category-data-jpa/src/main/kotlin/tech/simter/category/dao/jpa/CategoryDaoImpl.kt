package tech.simter.category.dao.jpa

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import tech.simter.category.dao.CategoryDao
import tech.simter.category.po.Category
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * The JPA implementation of [CategoryDao].
 *
 * @author RJ
 * @author JF
 */
@Component
class CategoryDaoImpl @Autowired constructor(
  @PersistenceContext private val em: EntityManager,
  private val repository: CategoryJpaRepository
) : CategoryDao {
  override fun findChild(parentParentId: Int, parentSNs: Array<String>, childStatuses: Array<Category.Status>): Flux<Category> {
    val hql = """
      select c from Category c
      inner join Category p on p.pid.id = :pPid and p.sn in (:pSNs)
      where c.pid = p.id and c.status in (:cStatuses)
      order by p.sn asc, c.status asc, c.sn asc
      """.trimIndent()
    return Flux.fromIterable(
      em.createQuery(hql, Category::class.java)
        .setParameter("pPid", parentParentId)
        .setParameter("pSNs", parentSNs.toList())
        .setParameter("cStatuses", childStatuses.toList())
        .resultList
    )
  }
}