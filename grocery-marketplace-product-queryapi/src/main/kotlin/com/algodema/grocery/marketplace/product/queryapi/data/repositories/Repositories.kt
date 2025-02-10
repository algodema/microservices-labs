package com.algodema.grocery.marketplace.product.queryapi.data.repositories

import com.algodema.grocery.marketplace.product.queryapi.data.entities.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Int>

@Repository
interface PriceRepository : JpaRepository<Price, Int>

@Repository
interface SupplierRepository : JpaRepository<Supplier, Int>

@Repository
interface RatingRepository : JpaRepository<Rating, Int>

@Repository
interface ManufacturerRepository : JpaRepository<Manufacturer, Int>

@Repository
interface WarrantyRepository : JpaRepository<Warranty, Int>

@Repository
interface TagRepository : JpaRepository<Tag, Int>

@Repository
interface PromotionRepository : JpaRepository<Promotion, Int>

@Repository
interface ProductRepository : JpaRepository<Product, Int>
