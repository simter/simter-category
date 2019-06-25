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
  @ManyToOne(cascade = [REMOVE])
  @JoinColumn(name = "PID")
  override val pid: CategoryPo?,
  @Convert(converter = CategoryStatusConverter::class)
  override val status: Status,
  @Column(nullable = false, length = 100)
  override val name: String,
  @Column(nullable = false, length = 50)
  override val sn: String
) : Category