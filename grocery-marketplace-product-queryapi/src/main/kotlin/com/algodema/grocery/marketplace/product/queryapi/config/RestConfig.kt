package com.algodema.grocery.marketplace.product.queryapi.config

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.core.mapping.ConfigurableHttpMethods
import org.springframework.data.rest.core.mapping.ResourceMetadata
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.http.HttpMethod
import org.springframework.web.filter.ForwardedHeaderFilter
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration
class SpringDataRestConfiguration : RepositoryRestConfigurer {
    companion object {
        const val BASE_PATH = "/grocery/marketplace/query/api/v1"
    }

    override fun configureRepositoryRestConfiguration(
        config: RepositoryRestConfiguration,
        cors: CorsRegistry,
    ) {
        val exposureConfiguration = config.setBasePath(BASE_PATH).exposureConfiguration
        exposureConfiguration.withItemExposure { metadata: ResourceMetadata?, httpMethods: ConfigurableHttpMethods ->
            httpMethods.disable(HttpMethod.PUT)
                .disable(HttpMethod.PATCH).disable(HttpMethod.POST).disable(HttpMethod.DELETE)
        }
            .withCollectionExposure { metadata: ResourceMetadata?, httpMethods: ConfigurableHttpMethods ->
                httpMethods.disable(HttpMethod.PUT)
                    .disable(HttpMethod.PATCH).disable(HttpMethod.POST).disable(HttpMethod.DELETE)
            }

        cors.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET")
            .allowCredentials(false).maxAge(3600)
    }

    /**
     * this bean aims at intercepting the http header X-Forwarded-Host in order to generate the correct link when this
     * spring data rest application is deployed behind a proxy, url redirection
     */
    @Bean
    fun forwardedHeaderFilter(): FilterRegistrationBean<ForwardedHeaderFilter>? {
        val bean: FilterRegistrationBean<ForwardedHeaderFilter> = FilterRegistrationBean<ForwardedHeaderFilter>()
        bean.filter = ForwardedHeaderFilter()
        return bean
    }
}
