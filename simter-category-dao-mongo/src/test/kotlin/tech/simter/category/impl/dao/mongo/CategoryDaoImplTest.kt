package tech.simter.category.impl.dao.mongo

import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import reactor.core.publisher.Mono
import reactor.kotlin.test.test
import tech.simter.category.core.CategoryDao
import tech.simter.category.impl.dao.mongo.po.CategoryPo

/**
 * Test [CategoryDaoImpl].
 *
 * @author RJ
 */
@SpringJUnitConfig(ModuleConfiguration::class)
@DataMongoTest
class CategoryDaoImplTest @Autowired constructor(
  private val operations: ReactiveMongoOperations,
  private val dao: CategoryDao
) {
  @BeforeEach
  fun setup() {
    // drop and create a new collection
    operations.collectionExists(CategoryPo::class.java)
      .flatMap { if (it) operations.dropCollection(CategoryPo::class.java) else Mono.just(it) }
      .then(operations.createCollection(CategoryPo::class.java))
      .test()
      .expectNextCount(1)
      .verifyComplete()
  }
}