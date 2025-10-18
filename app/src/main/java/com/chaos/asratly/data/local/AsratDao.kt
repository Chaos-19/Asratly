package com.chaos.asratly.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chaos.asratly.domain.model.AsratTransaction
import com.chaos.asratly.domain.model.Income

@Dao
interface AsratDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: AsratTransaction)

    @Query("SELECT SUM(amountPaid) FROM asrat_transactions")
    suspend fun getTotalAsratPaid(): Double?

    @Query("""
        SELECT SUM(I.asratAmountDue) - COALESCE(SUM(T.amountPaid), 0.0) 
        FROM incomes AS I 
        LEFT JOIN asrat_transactions AS T ON I.id = T.incomeId 
        WHERE (I.isAsratPaid = 0 OR I.isAsratPaid = 1)
    """)
    suspend fun getTotalAsratDue(): Double?

    @Query("SELECT * FROM incomes WHERE isAsratPaid = 0")
    suspend fun getPendingAsratIncomes(): List<Income>

    @Delete
    suspend fun delete(transaction: AsratTransaction)
}
/*
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chaos.asratly.domain.model.AsratTransaction

@Dao
interface AsratDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: AsratTransaction)

    @Query("SELECT SUM(amountPaid) FROM asrat_transactions")
    suspend fun getTotalAsratPaid(): Double?

    @Query("""
        SELECT SUM(I.asratAmountDue) - COALESCE(SUM(T.amountPaid), 0.0) 
        FROM incomes AS I 
        LEFT JOIN asrat_transactions AS T ON I.id = T.incomeId 
        WHERE (I.isAsratPaid = 0 OR I.isAsratPaid = 1)
    """)
    suspend fun getTotalAsratDue(currency: String): Double?

    @Query("SELECT * FROM incomes WHERE isAsratPaid = 0")
    suspend fun getPendingAsratIncomes(): List<Income>

    @Delete
    suspend fun delete(transaction: AsratTransaction)
}
*/