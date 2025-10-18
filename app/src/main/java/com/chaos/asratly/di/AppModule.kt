package com.chaos.asratly.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

import com.chaos.asratly.data.repository.FinanceRepository


import com.chaos.asratly.data.local.IncomeDao
import com.chaos.asratly.data.local.ExpenseDao
import com.chaos.asratly.data.local.AsratDao
import com.chaos.asratly.data.local.DebtDao

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFinanceRepository(
        incomeDao: IncomeDao,
        expenseDao: ExpenseDao,
        debtDao: DebtDao,
        asratDao: AsratDao
    ): FinanceRepository = FinanceRepository(incomeDao, expenseDao, debtDao, asratDao)
}