package com.chaos.asratly.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chaos.asratly.domain.model.AsratTransaction
import com.chaos.asratly.domain.model.Debt
import com.chaos.asratly.domain.model.Expense
import com.chaos.asratly.domain.model.Income

@Database(
    entities = [Income::class, Expense::class, Debt::class, AsratTransaction::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(FinancialConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun incomeDao(): IncomeDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun debtDao(): DebtDao
    abstract fun asratDao(): AsratDao
}