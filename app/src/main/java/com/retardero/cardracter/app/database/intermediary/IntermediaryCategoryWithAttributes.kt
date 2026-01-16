package com.retardero.cardracter.app.database.intermediary

import androidx.room.Embedded
import androidx.room.Relation

data class IntermediaryCategoryWithAttributes(
    @Embedded val category: IntermediaryCategory,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryId"
    ) val attributes: List<IntermediaryAttribute>
)
