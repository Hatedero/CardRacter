package com.retardero.cardracter.app.model

sealed class Card(
    var id: Int,
    var title: String,
    var image: Int
) {

    data class CollectionCard(
        var cardId: Int,
        var cardTitle: String,
        var cardImage: Int,
        var cardAttributes: List<CustomCategory.CardsCategory>
    ) : Card(cardId, cardTitle, cardImage) {
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
                listOf(CustomCategory.MultiAttributesCategory(0, "Story", listOf(CustomAttribute.TextAttribute(0, "attributeTitle", "He was a knight once told to save the world"))))
            )
        }
    }
}

//FOR LATER
/*data class CharacterCard(
            val characterAttributes: CharacterCardCategory,
            val cardBaseAttributes: CardCategory
        ) : MultiCategoryCard(cardBaseAttributes) {

            //val characterAttributes: CharacterCardCategory = characterAttributes

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