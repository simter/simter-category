package tech.simter.category.test

import tech.simter.category.core.Category
import tech.simter.util.RandomUtils.randomInt
import tech.simter.util.RandomUtils.randomString

/**
 * Some common tools for unit test.
 *
 * @author RJ
 */
object TestHelper {
  /** Create a random [Category.status] */
  fun randomCategoryStatus(): Category.Status {
    val index = randomInt(0, Category.Status.values().size - 1)
    return Category.Status.values().first { index == it.ordinal }
  }

  /** Create a random [Category] instance */
  fun randomCategory(
    id: Int? = null,
    parent: Category? = null,
    status: Category.Status = randomCategoryStatus(),
    name: String = randomString(6),
    sn: String = randomString(6)
  ): Category {
    return Category.of(id = id, pid = parent, name = name, status = status, sn = sn)
  }
}