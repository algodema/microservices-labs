package com.algodema.grocery.marketplace.orderservice.domain.models.product

import java.util.UUID

data class ProductId(val value: UUID) {
    companion object {
        fun from(productId: String): ProductId {
            return ProductId(UUID.fromString(productId))
        }
    }
}
