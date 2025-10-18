package com.chaos.asratly.data.repository

import com.chaos.asratly.data.local.AsratDao
import com.chaos.asratly.data.local.DebtDao
import com.chaos.asratly.data.local.ExpenseDao
import com.chaos.asratly.data.local.IncomeDao
import com.chaos.asratly.domain.model.AsratTransaction
import com.chaos.asratly.domain.model.Debt
import com.chaos.asratly.domain.model.DebtType
import com.chaos.asratly.domain.model.Expense
import com.chaos.asratly.domain.model.Income
import com.chaos.asratly.util.CurrencyConverter
import javax.inject.Inject


class FinanceRepository @Inject constructor(
    private val incomeDao: IncomeDao,
    private val expenseDao: ExpenseDao,
    private val debtDao: DebtDao,
    private val asratDao: AsratDao
) {
    suspend fun insertIncome(income: Income, inputCurrency: String) {
        val etbAmount = CurrencyConverter.convert(income.amount, inputCurrency, "ETB")
        val etbAsratDue = CurrencyConverter.convert(income.asratAmountDue, inputCurrency, "ETB")
        incomeDao.insert(income.copy(amount = etbAmount, asratAmountDue = etbAsratDue))
    }

    suspend fun insertExpense(expense: Expense, inputCurrency: String) {
        val etbAmount = CurrencyConverter.convert(expense.amount, inputCurrency, "ETB")
        expenseDao.insert(expense.copy(amount = etbAmount))
    }

    suspend fun insertDebt(debt: Debt, inputCurrency: String) {
        val etbAmount = CurrencyConverter.convert(debt.amount, inputCurrency, "ETB")
        debtDao.insert(debt.copy(amount = etbAmount))
    }

    suspend fun insertAsratTransaction(transaction: AsratTransaction, inputCurrency: String) {
        val etbAmount = CurrencyConverter.convert(transaction.amountPaid, inputCurrency, "ETB")
        asratDao.insert(transaction.copy(amountPaid = etbAmount))
    }

    suspend fun getTotalIncome(preferredCurrency: String): Double {
        val etbTotal = incomeDao.getTotalIncome() ?: 0.0
        return CurrencyConverter.convert(etbTotal, "ETB", preferredCurrency)
    }

    suspend fun getTotalExpenses(preferredCurrency: String): Double {
        val etbTotal = expenseDao.getTotalExpenses() ?: 0.0
        return CurrencyConverter.convert(etbTotal, "ETB", preferredCurrency)
    }

    suspend fun getTotalAsratPaid(preferredCurrency: String): Double {
        val etbTotal = asratDao.getTotalAsratPaid() ?: 0.0
        return CurrencyConverter.convert(etbTotal, "ETB", preferredCurrency)
    }

    suspend fun getTotalAsratDue(preferredCurrency: String): Double {
        val etbDue = asratDao.getTotalAsratDue() ?: 0.0
        return CurrencyConverter.convert(etbDue, "ETB", preferredCurrency)
    }

    suspend fun getAllIncomes(): List<Income> = incomeDao.getAllIncomes()
    suspend fun getAllExpenses(): List<Expense> = expenseDao.getAllExpenses()
    suspend fun getAllDebts(): List<Debt> = debtDao.getDebtsByType(DebtType.ASRAT_DEBT) // Example type
    suspend fun getPendingAsratIncomes(): List<Income> = asratDao.getPendingAsratIncomes()
    suspend fun deleteIncome(income: Income) = incomeDao.delete(income)
    suspend fun deleteExpense(expense: Expense) = expenseDao.delete(expense)
    suspend fun deleteDebt(debt: Debt) = debtDao.delete(debt)
    suspend fun deleteAsratTransaction(transaction: AsratTransaction) = asratDao.delete(transaction)
}