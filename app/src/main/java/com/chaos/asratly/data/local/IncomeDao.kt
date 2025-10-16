package com.chaos.asratly.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chaos.asratly.domain.model.Income

@Dao
interface IncomeDao {
    @Insert
    suspend fun insertIncome(income: Income)

    @Query("SELECT * FROM income")
    suspend fun getAllIncomes(): List<Income>
}