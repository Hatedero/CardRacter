package com.retardero.cardracter.app.model

import com.retardero.cardracter.app.model.CustomAttribute.NumberAttribute

sealed class ModifiableCard(
    var id: Int,
    var title: String,
    var image: Int
) {
    abstract fun <T> copy(id: Int? = null, title: String? = null, image: Int? = null, values: T? = null): Card

    data class CollectionCard(
        var cardId: Int,
        var cardTitle: String,
        var cardImage: Int,
        var cardAttributes: List<CustomCategory.CardsCategory>
    ) : Card(cardId, cardTitle, cardImage) {

        override fun <T> copy(id: Int?, title: String?, image: Int?, values: T?): Card {
            return CollectionCard(id ?: cardId, title ?: cardTitle, image ?: cardImage, (values ?: cardAttributes) as List<CustomCategory.CardsCategory>)
        }

        companion object {
            fun empty(): CollectionCard = CollectionCard(
                -1,
                "",
                -1,
                emptyList()
            )
        }
    }

    data class MultiCategoryCard(
        var cardId: Int,
        var cardTitle: String,
        var cardImage: Int,
        var cardAttributes: List<CustomCategory>
    ) : Card(cardId, cardTitle, cardImage) {

        override fun <T> copy(id: Int?, title: String?, image: Int?, values: T?): Card {
            return MultiCategoryCard(id ?: cardId, title ?: cardTitle, image ?: cardImage, (values ?: cardAttributes) as List<CustomCategory>)
        }

        companion object {
            fun empty(): MultiCategoryCard = MultiCategoryCard(
                -1,
                "",
                -1,
                emptyList()
            )

            fun testData(): MultiCategoryCard = MultiCategoryCard(
                0,
                "Artorias The abyss walker",
                0,
                listOf(CustomCategory.MultiAttributesCategory(0, "Story", listOf(CustomAttribute.TextAttribute(0, "attributeTitle", "He was a knight once told to save the world"), CustomAttribute.NumberAttribute(0, "attributeTitle", 1920f))),
                    CustomCategory.SingleAttributeCategory(0, "What makes him human", CustomAttribute.TextAttribute(0, "attributeTitle", "His most precious memory")))
            )
        }
    }
}

//FOR LATER
/*data class CharacterCard(
            var characterAttributes: CharacterCardCategory,
            var cardBaseAttributes: CardCategory
        ) : MultiCategoryCard(cardBaseAttributes) {

            //var characterAttributes: CharacterCardCategory = characterAttributes

            companion object {
                fun empty(): CharacterCard = CharacterCard(
                    cardBaseAttributes = CardCategory.Companion.empty(),
                    characterAttributes = CharacterCardCategory.Companion.empty()
                )

                fun testData(): CharacterCard = CharacterCard(
                    cardBaseAttributes = CardCategory.Companion.testData(),
                    characterAttributes = CharacterCardCategory.Companion.testData()
                )
            }*/