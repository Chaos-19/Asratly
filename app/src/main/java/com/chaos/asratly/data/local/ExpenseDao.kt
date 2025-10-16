package com.chaos.asratly.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chaos.asratly.domain.model.Expense

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM expense")
    suspend fun getAllExpenses(): List<Expense>
}