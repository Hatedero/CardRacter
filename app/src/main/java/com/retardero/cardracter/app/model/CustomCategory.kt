package com.retardero.cardracter.app.model

sealed class CustomCategory (
    val id: Int,
    val title: String,
) {
    abstract fun returnValues(): List<CustomAttribute>

    data class MultiAttributesCategory (
        val categoryId: Int,
        val categoryTitle: String,
        val attributes: List<CustomAttribute>
    ) : CustomCategory(categoryId, categoryTitle) {
        override fun returnValues(): List<CustomAttribute> {
            return attributes
        }

    }

    data class CardsCategory (
        val categoryId: Int,
        val categoryTitle: String,
        val cards: List<CustomAttribute.CardAttribute>
    ) : CustomCategory(categoryId, categoryTitle) {
        override fun returnValues(): List<CustomAttribute> {
            return cards
        }
    }

    data class SingleAttributeCategory (
        val categoryId: Int,
        val categoryTitle: String,
        val attribute: CustomAttribute
    ) : CustomCategory(categoryId, categoryTitle) {
        override fun returnValues(): List<CustomAttribute> {
            return listOf(attribute)
        }
    }
}