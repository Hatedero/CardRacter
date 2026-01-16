package com.retardero.cardracter.app.database.intermediary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "IntermediaryCard")
data class IntermediaryCard(
    @PrimaryKey
    var cardId: Int,
    @ColumnInfo
    var cardTitle: String,
    @ColumnInfo
    var cardImage: Int,
    @ColumnInfo
    var type: CardType
)

enum class CardType {
    Collection,
    MultiCategory
}
