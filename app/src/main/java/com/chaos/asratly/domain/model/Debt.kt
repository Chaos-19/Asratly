package com.chaos.asratly.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chaos.asratly.domain.model.DebtType



@Entity(tableName = "debts")
data class Debt(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val personOrEntityName: String, // Person or Entity Name
    val amount: Double, // Amount (positive for Owed To Me, negative for I Owe)
    val date: Long, // Date debt was incurred
    val reason: String? = null, // Reason/Note
    val debtType: DebtType, // Debt Type
    
)