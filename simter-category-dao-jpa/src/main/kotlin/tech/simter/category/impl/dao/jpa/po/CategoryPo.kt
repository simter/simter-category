package tech.simter.category.impl.dao.jpa.po

import tech.simter.category.TABLE_CATEGORY
import tech.simter.category.core.Category
import tech.simter.category.core.Category.Status
import tech.simter.category.impl.dao.jpa.po.converter.CategoryStatusConverter
import javax.persistence.*
import javax.persistence.CascadeType.REMOVE

/**
 * The JPA Entity implementation of [Category].
 *
 * @author RJ
 */
@Entity
@Table(name = TABLE_CATEGORY)
data class CategoryPo(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  override val id: Int?,
  @ManyToOne(cascade = [REMOVE], targetEntity = CategoryPo::class)
  @JoinColumn(name = "PID")
  override val pid: Category?,
  @Convert(converter = CategoryStatusConverter::class)
  override val status: Status,
  @Column(nullable = false, length = 100)
  override val name: String,
  @Column(nullable = false, length = 50)
  override val sn: String
) : Category {
  companion object {
    fun from(category: Category): CategoryPo {
      return if (category is CategoryPo) category else CategoryPo(
        id = category.id,
        pid = category.pid,
        status = category.status,
        name = category.name,
        sn = category.sn
      )
    }
  }
}