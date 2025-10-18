package com.chaos.asratly.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chaos.asratly.domain.model.ExpenseCategory
import com.chaos.asratly.domain.model.Income

@Dao
interface IncomeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(income: Income)

    @Query("SELECT * FROM incomes")
    suspend fun getAllIncomes(): List<Income>

    @Query("SELECT SUM(amount) FROM incomes")
    suspend fun getTotalIncome(): Double?

    @Query("SELECT * FROM incomes WHERE id = :id") // Select all fields
    suspend fun getIncomeDetails(id: Int): Income?

    @Delete
    suspend fun delete(income: Income)
}