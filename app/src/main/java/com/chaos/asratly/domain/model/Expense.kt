package com.chaos.asratly.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

enum class ExpenseCategory {
    FOOD, TRANSPORT, BILLS, ENTERTAINMENT, HEALTH, SHOPPING, OTHER
}

@Entity(
    tableName = "expenses",
    foreignKeys = [
        ForeignKey(
            entity = Income::class,
            parentColumns = ["id"],
            childColumns = ["paidFromIncomeId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index(value = ["paidFromIncomeId"]), Index(value = ["category"])]
)
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val expensTitle: String,
    val category: ExpenseCategory,
    val amount: Double,
    val paidFromIncomeId: Int? = null,
    val description: String,
    val date: Long
)