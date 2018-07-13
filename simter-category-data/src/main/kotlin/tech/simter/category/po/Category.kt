package tech.simter.category.po

import org.springframework.data.mongodb.core.mapping.Document
import tech.simter.category.po.converter.CategoryStatusConverter
import javax.persistence.*

/**
 * The PO.
 *
 * @author RJ
 */
@Entity
@Table(name = "st_category")
@Document(collection = "st_category")
data class Category(
  @javax.persistence.Id
  @org.springframework.data.annotation.Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Int?,
  /** Parent Category ID */
  @ManyToOne(cascade = [(CascadeType.REMOVE)]) val pid: Category?,
  /** Status */
  @Convert(converter = CategoryStatusConverter::class) val status: Status,
  /** Name */
  @Column(nullable = false, length = 100) val name: String,
  /** Code or order number */
  @Column(nullable = false, length = 50) val sn: String
) {
  enum class Status(private val value: Short) {
    /**
     * Draft.
     */
    Draft(1),
    /**
     * Enabled.
     */
    Enabled(2),
    /**
     * Disabled.
     */
    Disabled(4),
    /**
     * Deleted.
     */
    Deleted(8);

    fun value(): Short {
      return value
    }
  }
}