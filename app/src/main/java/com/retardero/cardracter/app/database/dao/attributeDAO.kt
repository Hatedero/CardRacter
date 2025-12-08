package com.retardero.cardracter.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.retardero.cardracter.app.database.intermediary.IntermediaryAttribute

@Dao
interface attributeDAO {
    @Insert
    suspend fun insertAttribute(attribute: IntermediaryAttribute)
}