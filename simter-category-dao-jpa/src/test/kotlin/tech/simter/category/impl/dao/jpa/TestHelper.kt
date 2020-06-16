package tech.simter.category.impl.dao.jpa

import tech.simter.category.core.Category
import tech.simter.category.impl.dao.jpa.po.CategoryPo
import tech.simter.category.test.TestHelper
import tech.simter.category.test.TestHelper.randomCategory
import tech.simter.util.RandomUtils

object TestHelper {
  fun randomCategoryPo(
    id: Int? = null,
    parent: Category? = null,
    status: Category.Status = TestHelper.randomCategoryStatus(),
    name: String = RandomUtils.randomString(6),
    sn: String = RandomUtils.randomString(6)
  ): CategoryPo = CategoryPo.from(randomCategory(
    id = id,
    parent = parent,
    status = status,
    name = name,
    sn = sn
  ))
}