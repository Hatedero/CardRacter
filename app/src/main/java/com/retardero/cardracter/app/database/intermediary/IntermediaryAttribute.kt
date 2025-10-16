package com.retardero.cardracter.app.database.intermediary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class IntermediaryAttribute(
    @PrimaryKey
    var attributeId: Int,
    @ColumnInfo
    var attributeTitle: String,
    @ColumnInfo
    var attributeValue: String,
    @ColumnInfo
    var type: AttributeType
) {

}

enum class AttributeType {
    Text,
    Number,
    Card
}