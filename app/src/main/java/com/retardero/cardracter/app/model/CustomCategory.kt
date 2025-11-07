package com.retardero.cardracter.app.model

import com.retardero.cardracter.app.model.Card.CollectionCard

sealed class CustomCategory (
    val id: Int,
    val title: String,
) {
    abstract fun returnValues(): List<CustomAttribute>
    abstract fun copy(id: Int? = null, title: String? = null, attributes : List<CustomAttribute>? = null): CustomCategory

    data class MultiAttributesCategory (
        val categoryId: Int,
        val categoryTitle: String,
        val attributes: List<CustomAttribute>
    ) : CustomCategory(categoryId, categoryTitle) {
        override fun returnValues(): List<CustomAttribute> {
            return attributes
        }

        override fun copy(
            id: Int?,
            title: String?,
            attributes: List<CustomAttribute>?
        ): CustomCategory {
            return MultiAttributesCategory(id ?: categoryId, title ?: categoryTitle, attributes ?: this.attributes)
        }

        companion object {
            fun empty(): MultiAttributesCategory = MultiAttributesCategory(
                -1,
                "",
                emptyList()
            )

            fun default(): MultiAttributesCategory = MultiAttributesCategory(
                0,
                "Title",
                emptyList()
            )
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

        override fun copy(
            id: Int?,
            title: String?,
            attributes: List<CustomAttribute>?
        ): CustomCategory {
            return CardsCategory(id ?: categoryId, title ?: categoryTitle, (attributes ?: cards) as List<CustomAttribute.CardAttribute>)
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

        override fun copy(
            id: Int?,
            title: String?,
            attributes: List<CustomAttribute>?
        ): CustomCategory {
            return SingleAttributeCategory(id ?: categoryId, title ?: categoryTitle, attributes?.first() ?: attribute)
        }
    }
}