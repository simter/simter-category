package tech.simter.category.dao.reactive.mongo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import tech.simter.category.dao.CategoryDao

/**
 * The Reactive MongoDB implementation of [CategoryDao].
 *
 * @author RJ
 */
@Component
class CategoryDaoImpl @Autowired constructor(
  private val repository: CategoryReactiveRepository
) : CategoryDao