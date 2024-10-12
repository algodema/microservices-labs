package com.algodema.grocery.marketplace.orderservice.infrastructure.api

import com.algodema.grocery.marketplace.orderservice.domain.features.PlaceOrder
import com.algodema.grocery.marketplace.orderservice.domain.models.order.Order
import com.algodema.grocery.marketplace.orderservice.domain.models.product.ProductId
import com.algodema.grocery.marketplace.orderservice.domain.models.provider.ProviderId
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrdersApi(private val placeOrder: PlaceOrder) {

    @PostMapping
    fun placeOrder(@RequestBody placeOrderRequest: PlaceOrderRequest): Order {

        val productId: ProductId = ProductId.from(placeOrderRequest.productId)
        val providerId: ProviderId = ProviderId.from(placeOrderRequest.providerId)
        val quantity: Int = placeOrderRequest.quantity

        return placeOrder.invoke(productId, providerId, quantity)
    }

}