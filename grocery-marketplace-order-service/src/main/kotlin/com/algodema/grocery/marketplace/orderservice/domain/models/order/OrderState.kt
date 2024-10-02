package com.algodema.grocery.marketplace.orderservice.domain.models.order

enum class OrderState {
    PLACED,
    PROCESSED,
    SHIPPED,
    DELIVERED,
    CANCELED,
}
