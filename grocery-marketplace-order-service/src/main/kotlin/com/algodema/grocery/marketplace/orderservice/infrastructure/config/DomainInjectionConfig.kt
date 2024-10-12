package com.algodema.grocery.marketplace.orderservice.infrastructure.config

import com.algodema.grocery.marketplace.orderservice.ddd.Feature
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["com.algodema.grocery.marketplace.orderservice"],
    includeFilters = [ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        value = [Feature::class]
    )]
)
open class DomainInjectionConfig