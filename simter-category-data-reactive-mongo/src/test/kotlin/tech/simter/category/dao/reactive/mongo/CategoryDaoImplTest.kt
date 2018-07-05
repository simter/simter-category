package tech.simter.category.dao.reactive.mongo

import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.repository.support.SimpleReactiveMongoRepository
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import tech.simter.category.dao.CategoryDao
import tech.simter.category.po.Category

/**
 * See [SimpleReactiveMongoRepository] implementation.
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
    StepVerifier.create(
      operations.collectionExists(Category::class.java)
        .flatMap { if (it) operations.dropCollection(Category::class.java) else Mono.just(it) }
        .then(operations.createCollection(Category::class.java))
    ).expectNextCount(1).verifyComplete()
  }
}