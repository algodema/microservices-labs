package com.algodema.grocery.marketplace.orderservice.domain.ports.outbound

import com.algodema.grocery.marketplace.orderservice.domain.models.order.Order

interface OrderRepository {

    fun save(order: Order): Order
}