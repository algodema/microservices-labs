package com.algodema.grocery.marketplace.orderservice.domain.ports.inbound

import com.algodema.grocery.marketplace.orderservice.domain.models.order.Order
import com.algodema.grocery.marketplace.orderservice.domain.models.product.ProductId
import com.algodema.grocery.marketplace.orderservice.domain.models.provider.ProviderId

interface PlaceOrder {
    fun invoke(productId: ProductId, providerId: ProviderId, quantity: Int): Order
}