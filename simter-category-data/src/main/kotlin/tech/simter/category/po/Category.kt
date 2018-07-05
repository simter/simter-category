package tech.simter.category.po

import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

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
  @Column(length = 100)
  val id: Int
)