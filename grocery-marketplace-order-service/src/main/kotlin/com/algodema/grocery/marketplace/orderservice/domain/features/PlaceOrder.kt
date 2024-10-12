package com.algodema.grocery.marketplace.orderservice.domain.features

import com.algodema.grocery.marketplace.orderservice.ddd.Feature
import com.algodema.grocery.marketplace.orderservice.domain.models.order.InsufficientOrderQuantityException
import com.algodema.grocery.marketplace.orderservice.domain.models.order.Order
import com.algodema.grocery.marketplace.orderservice.domain.models.order.OrderState
import com.algodema.grocery.marketplace.orderservice.domain.models.product.ProductId
import com.algodema.grocery.marketplace.orderservice.domain.models.provider.ProviderId
import com.algodema.grocery.marketplace.orderservice.domain.ports.inbound.PlaceOrder
import com.algodema.grocery.marketplace.orderservice.domain.ports.outbound.OrderRepository

@Feature
class PlaceOrder(private val repository: OrderRepository) : PlaceOrder {

    override fun invoke(productId: ProductId, providerId: ProviderId, quantity: Int): Order {
        return createOrderWithValidQuantity(productId, providerId, quantity)
    }

    private fun createOrderWithValidQuantity(productId: ProductId, providerId: ProviderId, quantity: Int): Order {
        if (quantity < Order.MIN_QUANTITY) throw InsufficientOrderQuantityException()
        val orderCreated = Order(productId, providerId, quantity, OrderState.PLACED)
        return repository.save(orderCreated)
    }


}