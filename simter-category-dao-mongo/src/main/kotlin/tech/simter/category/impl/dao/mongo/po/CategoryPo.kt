package tech.simter.category.impl.dao.mongo.po

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import tech.simter.category.TABLE_CATEGORY
import tech.simter.category.core.Category
import tech.simter.category.core.Category.Status

/**
 * The Document Entity implementation of [Category].
 *
 * @author RJ
 */
@Document(collection = TABLE_CATEGORY)
data class CategoryPo(
  @Id
  override val id: Int?,
  override val pid: CategoryPo?,
  override val status: Status,
  override val name: String,
  override val sn: String
) : Category