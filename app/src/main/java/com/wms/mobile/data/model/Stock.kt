package com.wms.mobile.data.model

import java.util.Date

/**
 * Maps to OOAD class: Stock, StockMovement, Location.
 */
data class Stock(
    val id: String,
    val item: Item,
    val location: Location,
    val quantity: Int,
    val updatedAt: Date = Date()
)

data class Location(
    val id: String,
    val code: String,
    val description: String
)

data class StockMovement(
    val id: String,
    val item: Item,
    val movementType: MovementType,
    val quantity: Int,
    val location: Location,
    val timestamp: Date = Date(),
    val referenceDocId: String? = null
)

enum class MovementType {
    IN,
    OUT,
    ADJUSTMENT
}
