package tech.simter.category.po.converter

import tech.simter.category.po.Category
import java.lang.IllegalArgumentException
import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * Implement the converter of [Category.Status] to database value.
 *
 * @author JF
 */
@Converter(autoApply = true)
class CategoryStatusConverter : AttributeConverter<Category.Status, Short> {
  override fun convertToDatabaseColumn(attribute: Category.Status): Short {
    return attribute.value()
  }

  override fun convertToEntityAttribute(dbData: Short): Category.Status {
    return when (dbData) {
      Category.Status.Draft.value() -> Category.Status.Draft
      Category.Status.Enabled.value() -> Category.Status.Enabled
      Category.Status.Disabled.value() -> Category.Status.Disabled
      Category.Status.Deleted.value() -> Category.Status.Deleted
      else -> throw IllegalArgumentException("Unable to convert '$dbData' to Category.Status.")
    }
  }
}