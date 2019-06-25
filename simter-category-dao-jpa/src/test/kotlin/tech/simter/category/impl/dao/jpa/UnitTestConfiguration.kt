package tech.simter.category.impl.dao.jpa

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * @author RJ
 */
@Configuration
@Import(
  tech.simter.reactive.jpa.ModuleConfiguration::class,
  tech.simter.reactive.test.ModuleConfiguration::class,
  ModuleConfiguration::class
)
@ComponentScan("tech.simter")
class UnitTestConfiguration