package com.algodema.domain.features

import com.algodema.grocery.marketplace.orderservice.domain.features.PlaceOrder
import com.algodema.grocery.marketplace.orderservice.domain.models.order.InsufficientOrderQuantityException
import com.algodema.grocery.marketplace.orderservice.domain.models.order.OrderState
import com.algodema.grocery.marketplace.orderservice.domain.models.product.ProductId
import com.algodema.grocery.marketplace.orderservice.domain.models.provider.ProviderId
import com.algodema.grocery.marketplace.orderservice.domain.ports.outbound.OrderRepository
import com.algodema.grocery.marketplace.orderservice.infrastructure.spi.InMemoryOrderRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class PlaceOrderTest {

    private val orderRepository: OrderRepository = InMemoryOrderRepository()
    private val placeOrder = PlaceOrder(orderRepository)

    @Test
    fun `should throw exception with quantity lower than 20`() {

        val productId: ProductId = ProductId(UUID.randomUUID())
        val providerId: ProviderId = ProviderId(UUID.randomUUID())
        val quantity: Int = 16

        Assertions.assertThrowsExactly(InsufficientOrderQuantityException::class.java) {
            placeOrder.invoke(productId, providerId, quantity)
        }
    }

    @Test
    fun `should place order with initial state PLACED`() {

        val productId: ProductId = ProductId(UUID.randomUUID())
        val providerId: ProviderId = ProviderId(UUID.randomUUID())
        val quantity: Int = 50

        val orderCreated = placeOrder.invoke(productId, providerId, quantity)

        Assertions.assertEquals(orderCreated.state, OrderState.PLACED)
    }

}