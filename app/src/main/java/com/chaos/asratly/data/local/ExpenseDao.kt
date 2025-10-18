package com.chaos.asratly.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chaos.asratly.domain.model.Expense

data class ExpenseCategoryTotal(
    val category: String,
    val totalAmount: Double
)

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: Expense)

    @Query("SELECT * FROM expenses")
    suspend fun getAllExpenses(): List<Expense>

    @Query("SELECT SUM(amount) FROM expenses")
    suspend fun getTotalExpenses(): Double?

    @Query("SELECT category AS category, SUM(amount) as totalAmount FROM expenses GROUP BY category")
    suspend fun getExpensesByCategory(): List<ExpenseCategoryTotal>

    @Delete
    suspend fun delete(expense: Expense)
}