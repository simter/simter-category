package tech.simter.category.dao.reactive.mongo

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import tech.simter.category.PACKAGE

/**
 * All configuration for this module.
 *
 * @author RJ
 */
@Configuration("$PACKAGE.dao.reactive.mongo.ModuleConfiguration")
@EnableReactiveMongoRepositories
@ComponentScan
class ModuleConfiguration