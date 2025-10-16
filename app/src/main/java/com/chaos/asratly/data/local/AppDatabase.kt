package com.chaos.asratly.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chaos.asratly.domain.model.Income
import com.chaos.asratly.domain.model.Expense
import com.chaos.asratly.domain.model.Debt

@Database(entities = [Income::class, Expense::class, Debt::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun incomeDao(): IncomeDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun debtDao(): DebtDao
}