package com.retardero.cardracter.collections.model

sealed class ModifiableCustomCategory (
    var id: Int,
    var title: String,
) {
    abstract fun returnValues(): List<ModifiableCustomAttribute>
    abstract fun copy(id: Int? = null, title: String? = null, attributes : List<ModifiableCustomAttribute>? = null): ModifiableCustomCategory

    data class ModifiableMultiAttributesCategory (
        var categoryId: Int,
        var categoryTitle: String,
        var attributes: List<ModifiableCustomAttribute>
    ) : ModifiableCustomCategory(categoryId, categoryTitle) {
        override fun returnValues(): List<ModifiableCustomAttribute> {
            return attributes
        }

        override fun copy(
            id: Int?,
            title: String?,
            attributes: List<ModifiableCustomAttribute>?
        ): ModifiableCustomCategory {
            return ModifiableMultiAttributesCategory(id ?: categoryId, title ?: categoryTitle, attributes ?: this.attributes)
        }

        companion object {
            fun empty(): ModifiableMultiAttributesCategory = ModifiableMultiAttributesCategory(
                -1,
                "",
                emptyList()
            )

            fun default(): ModifiableMultiAttributesCategory = ModifiableMultiAttributesCategory(
                0,
                "Title",
                emptyList()
            )
        }
    }

    data class ModifiableCardsCategory (
        var categoryId: Int,
        var categoryTitle: String,
        var cards: List<ModifiableCustomAttribute.ModifiableCardAttribute>
    ) : ModifiableCustomCategory(categoryId, categoryTitle) {
        override fun returnValues(): List<ModifiableCustomAttribute> {
            return cards
        }

        override fun copy(
            id: Int?,
            title: String?,
            attributes: List<ModifiableCustomAttribute>?
        ): ModifiableCustomCategory {
            return ModifiableCardsCategory(id ?: categoryId, title ?: categoryTitle, (attributes ?: cards) as List<ModifiableCustomAttribute.ModifiableCardAttribute>)
        }
    }

    data class ModifiableSingleAttributeCategory (
        var categoryId: Int,
        var categoryTitle: String,
        var attribute: ModifiableCustomAttribute
    ) : ModifiableCustomCategory(categoryId, categoryTitle) {
        override fun returnValues(): List<ModifiableCustomAttribute> {
            return listOf(attribute)
        }

        override fun copy(
            id: Int?,
            title: String?,
            attributes: List<ModifiableCustomAttribute>?
        ): ModifiableCustomCategory {
            return ModifiableSingleAttributeCategory(id ?: categoryId, title ?: categoryTitle, attributes?.first() ?: attribute)
        }
    }
}