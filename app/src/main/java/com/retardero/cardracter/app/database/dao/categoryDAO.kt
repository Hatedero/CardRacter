package com.retardero.cardracter.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.retardero.cardracter.app.database.intermediary.IntermediaryAttribute
import com.retardero.cardracter.app.database.intermediary.IntermediaryCategory
import com.retardero.cardracter.app.database.intermediary.IntermediaryCategoryWithAttributes

@Dao
interface categoryDAO {
    // Get a category with all its attributes
    @Transaction
    @Query("SELECT * FROM IntermediaryCategory WHERE categoryId = :categoryId")
    suspend fun getCategoryWithAttributes(categoryId: Int): IntermediaryCategoryWithAttributes

    // Get all categories with their attributes
    @Transaction
    @Query("SELECT * FROM IntermediaryCategory")
    suspend fun getAllCategoriesWithAttributes(): List<IntermediaryCategoryWithAttributes>

    @Insert
    suspend fun insertCategory(category: IntermediaryCategory)
}