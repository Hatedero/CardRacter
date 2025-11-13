package com.retardero.cardracter.collections.model

import com.retardero.cardracter.collections.model.ModifiableCustomAttribute
import com.retardero.cardracter.collections.model.ModifiableCustomCategory


sealed class ModifiableCard(
    var id: Int,
    var title: String,
    var image: Int
) {
    abstract fun <T> copy(id: Int? = null, title: String? = null, image: Int? = null, values: T? = null): ModifiableCard

    data class ModifiableCollectionCard(
        var cardId: Int,
        var cardTitle: String,
        var cardImage: Int,
        var cardAttributes: List<ModifiableCustomCategory.ModifiableCardsCategory>
    ) : ModifiableCard(cardId, cardTitle, cardImage) {

        override fun <T> copy(id: Int?, title: String?, image: Int?, values: T?): ModifiableCard {
            return ModifiableCollectionCard(id ?: cardId, title ?: cardTitle, image ?: cardImage, (values ?: cardAttributes) as List<ModifiableCustomCategory.ModifiableCardsCategory>)
        }

        companion object {
            fun empty(): ModifiableCollectionCard = ModifiableCollectionCard(
                -1,
                "",
                -1,
                emptyList()
            )
        }
    }

    data class ModifiableMultiCategoryCard(
        var cardId: Int,
        var cardTitle: String,
        var cardImage: Int,
        var cardAttributes: List<ModifiableCustomCategory>
    ) : ModifiableCard(cardId, cardTitle, cardImage) {

        override fun <T> copy(id: Int?, title: String?, image: Int?, values: T?): ModifiableCard {
            return ModifiableMultiCategoryCard(id ?: cardId, title ?: cardTitle, image ?: cardImage, (values ?: cardAttributes) as List<ModifiableCustomCategory>)
        }

        companion object {
            fun empty(): ModifiableMultiCategoryCard = ModifiableMultiCategoryCard(
                -1,
                "",
                -1,
                emptyList()
            )

            fun testData(): ModifiableMultiCategoryCard = ModifiableMultiCategoryCard(
                0,
                "Artorias The abyss walker",
                0,
                listOf(ModifiableCustomCategory.ModifiableMultiAttributesCategory(0, "Story", listOf(
                    ModifiableCustomAttribute.ModifiableTextAttribute(0, "attributeTitle", "He was a knight once told to save the world"), ModifiableCustomAttribute.ModifiableNumberAttribute(0, "attributeTitle", 1920f))),
                    ModifiableCustomCategory.ModifiableSingleAttributeCategory(0, "What makes him human", ModifiableCustomAttribute.ModifiableTextAttribute(0, "attributeTitle", "His most precious memory")))
            )
        }
    }
}

//FOR LATER
/*data class CharacterCard(
            var characterAttributes: CharacterCardCategory,
            var cardBaseAttributes: CardCategory
        ) : ModifiableMultiCategoryCard(cardBaseAttributes) {

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