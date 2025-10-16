package com.chaos.asratly.data.repository

import com.chaos.asratly.data.local.IncomeDao
import com.chaos.asratly.data.local.ExpenseDao
import com.chaos.asratly.data.local.DebtDao
import com.chaos.asratly.domain.model.Income
import com.chaos.asratly.domain.model.Expense
import com.chaos.asratly.domain.model.Debt

class FinanceRepository(
    private val incomeDao: IncomeDao,
    private val expenseDao: ExpenseDao,
    private val debtDao: DebtDao
) {
    suspend fun addIncome(income: Income) = incomeDao.insertIncome(income)
    suspend fun getIncomes() = incomeDao.getAllIncomes()
    suspend fun addExpense(expense: Expense) = expenseDao.insertExpense(expense)
    suspend fun getExpenses() = expenseDao.getAllExpenses()
    suspend fun addDebt(debt: Debt) = debtDao.insertDebt(debt)
    suspend fun getDebts() = debtDao.getAllDebts()
}