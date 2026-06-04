package com.wms.mobile.data.model

import java.util.Date

/**
 * Maps to OOAD: TransactionDocument (abstract) → GoodsReceipt + GoodsIssue.
 */
abstract class TransactionDocument(
    open val id: String,
    open val docNumber: String,
    open val date: Date,
    open val createdBy: User,
    open val status: DocumentStatus
)

enum class DocumentStatus {
    DRAFT,
    PENDING_APPROVAL,
    APPROVED,
    REJECTED
}

data class GoodsReceipt(
    override val id: String,
    override val docNumber: String,
    override val date: Date,
    override val createdBy: User,
    override val status: DocumentStatus,
    val supplier: Supplier,
    val details: List<GoodsReceiptDetail>
) : TransactionDocument(id, docNumber, date, createdBy, status)

data class GoodsReceiptDetail(
    val id: String,
    val item: Item,
    val quantity: Int,
    val location: Location
)

data class GoodsIssue(
    override val id: String,
    override val docNumber: String,
    override val date: Date,
    override val createdBy: User,
    override val status: DocumentStatus,
    val customer: Customer,
    val details: List<GoodsIssueDetail>
) : TransactionDocument(id, docNumber, date, createdBy, status)

data class GoodsIssueDetail(
    val id: String,
    val item: Item,
    val quantity: Int,
    val location: Location
)

data class Customer(
    val id: String,
    val name: String,
    val phone: String,
    val address: String
)
