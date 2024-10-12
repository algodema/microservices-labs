package com.algodema.grocery.marketplace.orderservice.infrastructure.spi

import com.algodema.grocery.marketplace.orderservice.domain.models.order.AlreadyPlacedOrderException
import com.algodema.grocery.marketplace.orderservice.domain.models.order.Order
import com.algodema.grocery.marketplace.orderservice.domain.ports.outbound.OrderRepository
import org.springframework.stereotype.Repository

@Repository
open class InMemoryOrderRepository : OrderRepository {
    private val orders: MutableSet<Order> = mutableSetOf()
    override fun save(order: Order): Order {
        val added = this.orders.add(order)
        if (!added) throw AlreadyPlacedOrderException()
        return order
    }
}