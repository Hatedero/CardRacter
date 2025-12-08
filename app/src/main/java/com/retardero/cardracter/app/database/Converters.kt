package com.retardero.cardracter.app.database

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.room.TypeConverter
import com.retardero.cardracter.app.database.intermediary.IntermediaryAttribute
import com.retardero.cardracter.app.database.intermediary.AttributeType
import com.retardero.cardracter.app.database.intermediary.CardType
import com.retardero.cardracter.app.database.intermediary.IntermediaryCategory
import com.retardero.cardracter.app.database.intermediary.CategoryType
import com.retardero.cardracter.app.database.intermediary.IntermediaryCard
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.model.CustomAttribute
import com.retardero.cardracter.app.model.CustomCategory
import com.retardero.cardracter.collections.model.ModifiableCard
import com.retardero.cardracter.collections.model.ModifiableCustomAttribute
import com.retardero.cardracter.collections.model.ModifiableCustomCategory

class Converters {

    //ATTRIBUTES
    @TypeConverter
    fun fromIntermediaryAttribute(attribute: IntermediaryAttribute): CustomAttribute {
        return when (attribute.type) {
            AttributeType.Number -> CustomAttribute.NumberAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.attributeValue.toFloat()
            )

            AttributeType.Text -> CustomAttribute.TextAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.attributeValue
            )

            AttributeType.Card -> CustomAttribute.CardAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.attributeValue.toInt()
            )
        }
    }

    @TypeConverter
    fun toIntermediaryAttribute(attribute: CustomAttribute): IntermediaryAttribute {
        return when (attribute) {
            is CustomAttribute.CardAttribute -> IntermediaryAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.value.toString(),
                AttributeType.Card
            )

            is CustomAttribute.TextAttribute -> IntermediaryAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.value,
                AttributeType.Text
            )

            is CustomAttribute.NumberAttribute -> IntermediaryAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.value.toString(),
                AttributeType.Number
            )
        }
    }

    //CATEGORIES
    @TypeConverter
    fun fromIntermediaryCategory(category: IntermediaryCategory): CustomCategory {
        var attributes = listOf<CustomAttribute>()
        var converter = Converters()

        /*category.attributes.forEach { intermediaryAttribute ->
            attributes = attributes.plus(converter.fromIntermediaryAttribute(intermediaryAttribute))
        }*/

        return when (category.type) {
            CategoryType.MultiAttributes -> CustomCategory.MultiAttributesCategory(
                category.categoryId,
                category.categoryTitle,
                attributes
            )

            CategoryType.SingleAttribute -> CustomCategory.SingleAttributeCategory(
                category.categoryId,
                category.categoryTitle,
                CustomAttribute.TextAttribute(0, "", "")
            )

            CategoryType.Cards -> CustomCategory.CardsCategory(
                category.categoryId,
                category.categoryTitle,
                attributes as List<CustomAttribute.CardAttribute>
            )
        }
    }

    @TypeConverter
    fun toIntermediaryCategory(category: CustomCategory): IntermediaryCategory {
        return when (category) {
            is CustomCategory.CardsCategory -> IntermediaryCategory(
                category.categoryId,
                category.categoryTitle,
                CategoryType.Cards,
            )

            is CustomCategory.MultiAttributesCategory -> IntermediaryCategory(
                category.categoryId,
                category.categoryTitle,
                CategoryType.MultiAttributes,
            )

            is CustomCategory.SingleAttributeCategory -> IntermediaryCategory(
                category.categoryId,
                category.categoryTitle,
                CategoryType.SingleAttribute,
            )
        }
    }

    //CARD
    @TypeConverter
    fun fromIntermediaryCard(card: IntermediaryCard): Card {
        return when (card.type) {
            CardType.MultiCategory -> Card.MultiCategoryCard(
                card.cardId,
                card.cardTitle,
                card.cardImage,
                emptyList()
            )

            CardType.Collection -> Card.MultiCategoryCard(
                card.cardId,
                card.cardTitle,
                card.cardImage,
                emptyList()
            )
        }
    }

    @TypeConverter
    fun toIntermediaryCard(card: Card): IntermediaryCard {
        return when (card) {
            is Card.MultiCategoryCard -> IntermediaryCard(
                card.cardId,
                card.cardTitle,
                card.cardImage,
                CardType.MultiCategory
            )

            is Card.CollectionCard -> IntermediaryCard(
                card.cardId,
                card.cardTitle,
                card.cardImage,
                CardType.Collection
            )
        }
    }

    //MODIFIABLE_ATTRIBUTES
    @TypeConverter
    fun fromModifiableAttribute(attribute: ModifiableCustomAttribute): CustomAttribute {
        return when (attribute) {
            is ModifiableCustomAttribute.ModifiableTextAttribute -> CustomAttribute.TextAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.value
            )

            is ModifiableCustomAttribute.ModifiableNumberAttribute -> CustomAttribute.NumberAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.value.toFloat()
            )

            is ModifiableCustomAttribute.ModifiableCardAttribute -> CustomAttribute.CardAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.value.toInt()
            )
        }
    }

    @TypeConverter
    fun toModifiableAttribute(attribute: CustomAttribute): ModifiableCustomAttribute {
        return when (attribute) {
            is CustomAttribute.TextAttribute -> ModifiableCustomAttribute.ModifiableTextAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.value
            )

            is CustomAttribute.NumberAttribute -> ModifiableCustomAttribute.ModifiableNumberAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.value.toFloat()
            )

            is CustomAttribute.CardAttribute -> ModifiableCustomAttribute.ModifiableCardAttribute(
                attribute.attributeId,
                attribute.attributeTitle,
                attribute.value.toInt()
            )
        }
    }

    //MODIFIABLE_CATEGORIES
    @TypeConverter
    fun fromModifiableCategory(category: ModifiableCustomCategory): CustomCategory {
        return when (category) {
            is ModifiableCustomCategory.ModifiableMultiAttributesCategory -> CustomCategory.MultiAttributesCategory(
                category.categoryId,
                category.categoryTitle,
                emptyList()
            )

            is ModifiableCustomCategory.ModifiableCardsCategory -> CustomCategory.CardsCategory(
                category.categoryId,
                category.categoryTitle,
                emptyList()
            )

            is ModifiableCustomCategory.ModifiableSingleAttributeCategory -> CustomCategory.SingleAttributeCategory(
                category.categoryId,
                category.categoryTitle,
                fromModifiableAttribute(category.attribute)
            )

        }
    }

    @TypeConverter
    fun toModifiableCategory(category: CustomCategory): ModifiableCustomCategory {
        return when (category) {
            is CustomCategory.MultiAttributesCategory -> ModifiableCustomCategory.ModifiableMultiAttributesCategory(
                category.categoryId,
                category.categoryTitle,
                emptyList()
            )

            is CustomCategory.CardsCategory -> ModifiableCustomCategory.ModifiableCardsCategory(
                category.categoryId,
                category.categoryTitle,
                emptyList()
            )

            is CustomCategory.SingleAttributeCategory -> ModifiableCustomCategory.ModifiableSingleAttributeCategory(
                category.categoryId,
                category.categoryTitle,
                toModifiableAttribute(category.attribute)
            )
        }
    }

    //MODIFIABLE_CARD
    @TypeConverter
    fun fromModifiableCard(card: ModifiableCard): Card {
        return when (card) {
            is ModifiableCard.ModifiableMultiCategoryCard -> Card.MultiCategoryCard(
                card.cardId,
                card.cardTitle,
                card.cardImage,
                emptyList()
            )

            is ModifiableCard.ModifiableCollectionCard -> Card.CollectionCard(
                card.cardId,
                card.cardTitle,
                card.cardImage,
                fromModifiableCategory(card.cardAttribute) as CustomCategory.CardsCategory
            )
        }
    }

    @TypeConverter
    fun toModifiableCard(card: Card): ModifiableCard {
        return when (card) {
            is Card.MultiCategoryCard -> ModifiableCard.ModifiableMultiCategoryCard(
                card.cardId,
                card.cardTitle,
                card.cardImage,
                emptyList()
            )

            is Card.CollectionCard -> ModifiableCard.ModifiableCollectionCard(
                card.cardId,
                card.cardTitle,
                card.cardImage,
                toModifiableCategory(card.cardAttributes) as ModifiableCustomCategory.ModifiableCardsCategory
            )
        }
    }
}