package com.algodema.grocery.marketplace.product.queryapi.data.entities

import jakarta.persistence.*

@Entity
data class Warranty(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int? = null,
    val durationMonths: Int
)
