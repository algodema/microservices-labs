package com.algodema.grocery.marketplace.product.queryapi.config

import org.flywaydb.core.Flyway
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FlywayConfig {
    @Bean
    fun cleanAndMigrate(flyway: Flyway): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            // Clean the database schema
            flyway.clean()

            // Migrate (apply all migrations)
            flyway.migrate()
        }
    }
}
