package com.chaos.asratly.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "debt")
data class Debt(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val description: String,
    val date: Long
)