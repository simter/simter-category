package tech.simter.category.impl.dao.jpa

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import tech.simter.category.PACKAGE

/**
 * All configuration for this module.
 *
 * @author RJ
 */
@Configuration("$PACKAGE.impl.dao.jpa.ModuleConfiguration")
@ComponentScan
@EnableJpaRepositories
@EntityScan("$PACKAGE.impl.dao.jpa.po")
class ModuleConfiguration