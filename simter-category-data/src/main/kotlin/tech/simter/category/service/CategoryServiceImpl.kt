package tech.simter.category.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import tech.simter.category.dao.CategoryDao

@Component
@Transactional
class CategoryServiceImpl @Autowired constructor(
  private val dao: CategoryDao
) : CategoryService