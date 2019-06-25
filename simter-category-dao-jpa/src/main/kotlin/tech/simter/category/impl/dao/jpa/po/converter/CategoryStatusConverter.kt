package tech.simter.category.impl.dao.jpa.po.converter

import tech.simter.category.core.Category
import tech.simter.category.core.Category.Status.*
import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * Implement the converter of [Category.Status] to database value.
 *
 * @author RJ
 */
@Converter(autoApply = true)
class CategoryStatusConverter : AttributeConverter<Category.Status, Short> {
  override fun convertToDatabaseColumn(attribute: Category.Status): Short {
    return attribute.value
  }

  override fun convertToEntityAttribute(dbData: Short): Category.Status {
    return when (dbData) {
      Draft.value -> Draft
      Enabled.value -> Enabled
      Disabled.value -> Disabled
      Deleted.value -> Deleted
      else -> throw IllegalArgumentException("Unable to convert '$dbData' to Category.Status.")
    }
  }
}