package com.algodema.grocery.marketplace.orderservice.domain.features

import com.algodema.grocery.marketplace.orderservice.domain.models.order.InsufficientOrderQuantityException
import com.algodema.grocery.marketplace.orderservice.domain.models.order.Order
import com.algodema.grocery.marketplace.orderservice.domain.models.order.OrderState
import com.algodema.grocery.marketplace.orderservice.domain.models.product.ProductId
import com.algodema.grocery.marketplace.orderservice.domain.models.provider.ProviderId

class PlaceOrderFeature {

    fun invoke(productId: ProductId, providerId: ProviderId, quantity: Int): Order {
        return createOrderWithValidQuantity(productId, providerId, quantity)
    }

    private fun createOrderWithValidQuantity(productId: ProductId, providerId: ProviderId, quantity: Int): Order {
        if (quantity < Order.MIN_QUANTITY) throw InsufficientOrderQuantityException()
        return Order(productId, providerId, quantity, OrderState.PLACED)
    }


}