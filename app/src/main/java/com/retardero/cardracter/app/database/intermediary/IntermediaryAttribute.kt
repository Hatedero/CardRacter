package com.retardero.cardracter.app.database.intermediary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = IntermediaryCategory::class,
        parentColumns = ["categoryId"],
        childColumns = ["categoryId"],
        onDelete = ForeignKey.CASCADE // Delete attributes if the category is deleted
    )]
)
data class IntermediaryAttribute(
    @PrimaryKey
    var attributeId: Int,
    @ColumnInfo
    var attributeTitle: String,
    @ColumnInfo
    var attributeValue: String,
    @ColumnInfo
    var type: AttributeType,
    @ColumnInfo
    var categoryId: Int // Foreign key to IntermediaryCategory
)

enum class AttributeType {
    Text,
    Number,
    Card
}