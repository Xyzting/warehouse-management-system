package com.wms.mobile.data.model

/**
 * Maps to OOAD class: User.
 * Setiap user punya 1 role (Operator, Supervisor, atau Admin).
 */
data class User(
    val id: String,
    val username: String,
    val fullName: String,
    val email: String,
    val role: Role,
    val isActive: Boolean = true
)

data class Role(
    val id: String,
    val name: String,
    val permissions: List<String>
)
