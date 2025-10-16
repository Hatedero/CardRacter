package com.retardero.cardracter.app.model

sealed class CustomCategory (
    val id: Int,
    val title: String
) {
    data class MultiAttributesCategory (
        val categoryId: Int,
        val categoryTitle: String,
        val attributes: List<CustomAttribute>
    ) : CustomCategory(categoryId, categoryTitle) {

    }

    data class CardsCategory (
        val categoryId: Int,
        val categoryTitle: String,
        val cards: List<CustomAttribute.CardAttribute>
    ) : CustomCategory(categoryId, categoryTitle) {

    }

    data class SingleAttributeCategory (
        val categoryId: Int,
        val categoryTitle: String,
        val attribute: CustomAttribute
    ) : CustomCategory(categoryId, categoryTitle) {

    }
}