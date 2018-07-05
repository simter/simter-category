package tech.simter.category.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import tech.simter.category.dao.CategoryDao

@SpringJUnitConfig(CategoryServiceImpl::class)
@MockBean(CategoryDao::class)
class CategoryServiceImplTest @Autowired constructor(
  private val dao: CategoryDao,
  private val service: CategoryService
)