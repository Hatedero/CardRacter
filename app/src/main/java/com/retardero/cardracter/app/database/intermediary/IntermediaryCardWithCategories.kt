package com.retardero.cardracter.app.database.intermediary

import androidx.room.Embedded
import androidx.room.Relation

data class IntermediaryCardWithCategories(
    @Embedded val card: IntermediaryCard,
    @Relation(
        parentColumn = "cardId",
        entityColumn = "cardId"
    ) val categories: List<IntermediaryCategory>
)
