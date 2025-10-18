package com.chaos.asratly.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "asrat_transactions",
    foreignKeys = [
        ForeignKey(
            entity = Income::class,
            parentColumns = ["id"],
            childColumns = ["incomeId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["incomeId"])]
)
data class AsratTransaction(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amountPaid: Double,
    val incomeId: Int,
    val paymentDate: Long,
    val note: String? = null
)