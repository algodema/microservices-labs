package com.algodema.grocery.marketplace.orderservice.infrastructure.api

data class PlaceOrderRequest(val productId: String, val providerId: String, val quantity: Int)
