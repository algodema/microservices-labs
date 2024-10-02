package com.algodema.grocery.marketplace.orderservice.domain.models.order

import com.algodema.grocery.marketplace.orderservice.domain.models.product.ProductId
import com.algodema.grocery.marketplace.orderservice.domain.models.provider.ProviderId

data class Order(val productId: ProductId, val providerId: ProviderId, val quantity: Int, val state: OrderState)
