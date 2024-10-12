package com.algodema.grocery.marketplace.orderservice.domain.models.provider

import java.util.*

data class ProviderId(val value: UUID) {
    companion object {
        fun from(providerId: String): ProviderId {
            return ProviderId(UUID.fromString(providerId))
        }
    }
}
