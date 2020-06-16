package tech.simter.category.rest.webflux

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.TEXT_PLAIN
import org.springframework.web.reactive.function.server.router
import tech.simter.category.PACKAGE

/**
 * All configuration for this module.
 *
 * Register a `RouterFunction<ServerResponse>` with all routers for this module.
 * The default context-path of this router is '/category'. And can be config by property `simter-category.rest-context-path`.
 *
 * @author RJ
 */
@Configuration("$PACKAGE.rest.webflux.ModuleConfiguration")
@ComponentScan
class ModuleConfiguration @Autowired constructor(
  @Value("\${simter-category.rest-context-path:/category}") private val contextPath: String,
  @Value("\${simter-category.version:UNKNOWN}") private val version: String
) {
  private val logger = LoggerFactory.getLogger(ModuleConfiguration::class.java)

  init {
    logger.warn("simter-category.rest-context-path='{}'", contextPath)
    logger.warn("simter-category.version='{}'", version)
  }

  /** Register a `RouterFunction<ServerResponse>` with all routers for this module */
  @Bean("$PACKAGE.rest.webflux.Routes")
  @ConditionalOnMissingBean(name = ["$PACKAGE.rest.webflux.Routes"])
  fun categoryRoutes() = router {
    contextPath.nest {
      // GET /
      GET("/") { ok().contentType(TEXT_PLAIN).bodyValue("simter-category-rest-webflux-$version") }
    }
  }
}