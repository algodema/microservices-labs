package com.algodema.grocery.marketplace.product.queryapi.data.entities

import jakarta.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int? = null,
    val name: String,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category,

    @ManyToOne
    @JoinColumn(name = "price_id")
    val price: Price,

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    val supplier: Supplier,

    @ManyToOne
    @JoinColumn(name = "rating_id")
    val rating: Rating,

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    val manufacturer: Manufacturer,

    @ManyToOne
    @JoinColumn(name = "warranty_id")
    val warranty: Warranty,

    @ManyToOne
    @JoinColumn(name = "tag_id")
    val tag: Tag,

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    val promotion: Promotion,

    val description: String
)

