package com.algodema.grocery.marketplace.product.queryapi.data.entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Price(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int? = null,
    val amount: BigDecimal
)
