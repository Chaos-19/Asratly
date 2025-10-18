package com.chaos.asratly.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chaos.asratly.domain.model.Debt
import com.chaos.asratly.domain.model.DebtType

@Dao
interface DebtDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(debt: Debt)

    @Query("SELECT * FROM debts WHERE debtType = :type")
    suspend fun getDebtsByType(type: DebtType): List<Debt>

    @Query("SELECT SUM(amount) FROM debts")
    suspend fun getTotalDebts(): Double?

    @Delete
    suspend fun delete(debt: Debt)
}