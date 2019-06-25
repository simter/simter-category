package tech.simter.category.starter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.CacheControl
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.web.reactive.config.*
import org.springframework.web.reactive.function.server.router
import java.time.OffsetDateTime
import java.util.concurrent.TimeUnit

/**
 * Application WebFlux Configuration.
 *
 * see [WebFlux config API](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-config-enable)
 *
 * @author RJ
 */
@Configuration("tech.simter.category.starter.AppConfiguration")
@EnableWebFlux
class AppConfiguration @Autowired constructor(
  @Value("\${module.version.simter:UNKNOWN}") private val simterVersion: String,
  @Value("\${module.version.simter-category:UNKNOWN}") private val categoryVersion: String
) {
  /**
   * Register by method [DelegatingWebFluxConfiguration.setConfigurers].
   *
   * See [WebFlux config API](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-config-enable)
   */
  @Bean
  fun rootWebFluxConfigurer(): WebFluxConfigurer {
    return object : WebFluxConfigurer {
      /**
       * CORS config.
       *
       * See [Enabling CORS](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-cors)
       */
      override fun addCorsMappings(registry: CorsRegistry?) {
        // Enabling CORS for the whole application
        // By default all origins and GET, HEAD, and POST methods are allowed
        registry!!.addMapping("/**")
          .allowedOrigins("*")
          .allowedMethods("*")
          .allowedHeaders("Authorization", "Content-Type", "Content-Disposition")
          .exposedHeaders("Location")
          .allowCredentials(false)
          .maxAge(1800) // seconds
      }

      /** See [Static Resources](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-config-static-resources) */
      override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/static/**")
          .addResourceLocations("classpath:/META-INF/resources/static/")
          .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
      }
    }
  }

  private val startTime = OffsetDateTime.now()
  private val rootPage: String = """
    <h2>Simter Category Micro Service</h2>
    <div>Start at : $startTime</div>
    <div>Version : $categoryVersion</div>
    <ul>
      <li>simter-$simterVersion</li>
    </ul>
  """.trimIndent()

  /**
   * Other application routes.
   */
  @Bean
  fun rootRoutes() = router {
    "/".nest {
      // root /
      GET("/") { ok().contentType(TEXT_HTML).syncBody(rootPage) }

      // OPTIONS /*
      OPTIONS("/**") { noContent().build() }
    }
  }
}