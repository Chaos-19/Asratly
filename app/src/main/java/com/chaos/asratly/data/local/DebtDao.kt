package com.chaos.asratly.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chaos.asratly.domain.model.Debt

@Dao
interface DebtDao {
    @Insert
    suspend fun insertDebt(debt: Debt)

    @Query("SELECT * FROM debt")
    suspend fun getAllDebts(): List<Debt>
}