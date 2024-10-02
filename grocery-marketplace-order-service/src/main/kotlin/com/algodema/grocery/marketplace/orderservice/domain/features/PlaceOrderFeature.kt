package com.algodema.grocery.marketplace.orderservice.domain.features

import com.algodema.grocery.marketplace.orderservice.domain.models.order.Order
import com.algodema.grocery.marketplace.orderservice.domain.models.order.OrderState
import com.algodema.grocery.marketplace.orderservice.domain.models.product.ProductId
import com.algodema.grocery.marketplace.orderservice.domain.models.provider.ProviderId

class PlaceOrderFeature {

    fun invoke(productId: ProductId, providerId: ProviderId, quantity: Int): Order {

        return Order(productId, providerId, quantity, OrderState.PLACED)
    }


}