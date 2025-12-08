package com.retardero.cardracter.app.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.retardero.cardracter.app.database.intermediary.IntermediaryCard
import com.retardero.cardracter.app.model.Card

@Dao
interface cardDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(card: IntermediaryCard)

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cards: List<Card>)*/

    @Query("Select * from intermediarycard")
    suspend fun getAll(): List<IntermediaryCard>

    @Query("Select * from intermediarycard Where cardId = 0")
    suspend fun get(): IntermediaryCard

    /*@Delete
    suspend fun delete(card: Card)*/
}