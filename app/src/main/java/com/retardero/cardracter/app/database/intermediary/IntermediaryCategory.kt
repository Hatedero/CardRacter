package com.retardero.cardracter.app.database.intermediary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class IntermediaryCategory(
    @PrimaryKey
    var categoryId: Int,
    @ColumnInfo
    var categoryTitle: String,
    @ColumnInfo
    var type: CategoryType,
) {

}

enum class CategoryType {
    MultiAttributes,
    SingleAttribute,
    Cards
}