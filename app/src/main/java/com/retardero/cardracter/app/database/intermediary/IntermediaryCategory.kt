package com.retardero.cardracter.app.database.intermediary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "IntermediaryCategory",
    foreignKeys = [ForeignKey(
        entity = IntermediaryCard::class,
        parentColumns = ["cardId"],
        childColumns = ["cardId"],
        onDelete = ForeignKey.CASCADE // Delete categories when card is deleted
    )]
)
data class IntermediaryCategory(
    @PrimaryKey
    var categoryId: Int,
    @ColumnInfo
    var categoryTitle: String,
    @ColumnInfo
    var type: CategoryType,
    @ColumnInfo
    var cardId: Int // Foreign key to IntermediaryCard
)

enum class CategoryType {
    MultiAttributes,
    SingleAttribute,
    Cards
}
