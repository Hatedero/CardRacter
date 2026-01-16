package com.retardero.cardracter.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.retardero.cardracter.app.database.intermediary.IntermediaryAttribute
import com.retardero.cardracter.app.database.intermediary.IntermediaryCategory

@Dao
interface attributeDAO {
    @Insert
    suspend fun insertAttribute(attribute: IntermediaryAttribute)

    @Query("SELECT * FROM intermediaryattribute WHERE categoryId = :categoryId")
    suspend fun getAllAttributesFromCategory(categoryId: Int): List<IntermediaryAttribute>

    @Query("SELECT attributeId FROM intermediaryattribute ORDER BY attributeId DESC LIMIT 1")
    suspend fun getHighestAttributeId(): Int
}