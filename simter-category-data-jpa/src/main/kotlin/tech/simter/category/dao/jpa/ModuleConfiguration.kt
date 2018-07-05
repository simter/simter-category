package tech.simter.category.dao.jpa

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

private const val MODULE = "tech.simter.category"

/**
 * All configuration for this module.
 *
 * @author RJ
 */
@Configuration("$MODULE.dao.jpa.ModuleConfiguration")
@ComponentScan("$MODULE.dao.jpa")
@EnableJpaRepositories("$MODULE.dao.jpa")
@EntityScan("$MODULE.po")
class ModuleConfiguration