package com.wms.mobile.data.model

/**
 * Maps to OOAD class: Item, Category, Supplier.
 * Master data product.
 */
data class Item(
    val id: String,
    val sku: String,
    val name: String,
    val description: String,
    val unit: String,
    val category: Category,
    val supplier: Supplier,
    val minStock: Int = 0
)

data class Category(
    val id: String,
    val name: String
)

data class Supplier(
    val id: String,
    val name: String,
    val phone: String,
    val address: String
)
