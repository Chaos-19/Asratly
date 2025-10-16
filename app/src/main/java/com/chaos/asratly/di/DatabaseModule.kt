package com.chaos.asratly.di

import android.content.Context
import androidx.room.Room
import com.chaos.asratly.data.local.AppDatabase
import com.chaos.asratly.data.local.IncomeDao
import com.chaos.asratly.data.local.ExpenseDao
import com.chaos.asratly.data.local.DebtDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "asratly_database"
        ).build()
    }

    @Provides
    fun provideIncomeDao(database: AppDatabase): IncomeDao {
        return database.incomeDao()
    }

    @Provides
    fun provideExpenseDao(database: AppDatabase): ExpenseDao {
        return database.expenseDao()
    }

    @Provides
    fun provideDebtDao(database: AppDatabase): DebtDao {
        return database.debtDao()
    }
}