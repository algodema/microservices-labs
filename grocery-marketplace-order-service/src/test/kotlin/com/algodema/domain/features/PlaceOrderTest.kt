package com.algodema.domain.features

import com.algodema.grocery.marketplace.orderservice.domain.features.PlaceOrderFeature
import com.algodema.grocery.marketplace.orderservice.domain.models.order.OrderState
import com.algodema.grocery.marketplace.orderservice.domain.models.product.ProductId
import com.algodema.grocery.marketplace.orderservice.domain.models.provider.ProviderId
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class PlaceOrderTest {

    private val placeOrder = PlaceOrderFeature()

    @Test
    fun `should not place order with quantity lower than 20`() {

        val productId: ProductId = ProductId(UUID.randomUUID())
        val providerId: ProviderId = ProviderId(UUID.randomUUID())
        val quantity: Int = 16

        val orderCreated = placeOrder.invoke(productId, providerId, quantity)

        Assertions.assertEquals(orderCreated.state, OrderState.PLACED)
    }
}