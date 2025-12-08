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

    @Query("SELECT cardId FROM intermediarycard ORDER BY cardId DESC LIMIT 1")
    suspend fun getHighestCardId(): Int

    @Query("SELECT * FROM intermediarycard WHERE type = 'MultiCategory'")
    suspend fun getAllMultiCategoryCards(): List<IntermediaryCard>

    @Query("SELECT * FROM intermediarycard WHERE cardId = :id")
    suspend fun get(id : Int): IntermediaryCard

    @Query("SELECT * FROM intermediarycard WHERE type = 'Collection'")
    suspend fun getAllUserCollections(): List<IntermediaryCard>

    /*@Delete
    suspend fun delete(card: Card)*/
}