package com.chaos.asratly.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "incomes")
data class Income(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val source: String, // Source Name
    val amount: Double, // Amount
    val description: String, // Description
    val date: Long, // Date received (timestamp)
    val isAsratDeductable: Boolean = true, // Whether Asrat applies
    val isAsratPaid: Boolean = false, // Asrat Paid status
    val asratAmountDue: Double = 0.1 // Calculated as 10% of amount if deductable
)