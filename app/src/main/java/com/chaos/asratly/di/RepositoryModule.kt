package com.chaos.asratly.di

import com.chaos.asratly.data.local.IncomeDao
import com.chaos.asratly.data.local.ExpenseDao
import com.chaos.asratly.data.local.DebtDao
import com.chaos.asratly.data.local.AsratDao
import com.chaos.asratly.data.repository.FinanceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideFinanceRepository(
        incomeDao: IncomeDao,
        expenseDao: ExpenseDao,
        debtDao: DebtDao,
        asratDao: AsratDao
    ): FinanceRepository {
        return FinanceRepository(incomeDao, expenseDao, debtDao,asratDao)
    }
}