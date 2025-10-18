package com.chaos.asratly.data.local

import androidx.room.TypeConverter
import com.chaos.asratly.domain.model.DebtType
import com.chaos.asratly.domain.model.ExpenseCategory

class FinancialConverters {
    @TypeConverter
    fun fromExpenseCategory(category: ExpenseCategory): String = category.name

    @TypeConverter
    fun toExpenseCategory(value: String): ExpenseCategory = enumValueOf(value)

    @TypeConverter
    fun fromDebtType(type: DebtType): String = type.name

    @TypeConverter
    fun toDebtType(value: String): DebtType = enumValueOf(value)
}