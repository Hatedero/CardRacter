package com.retardero.cardracter.app.database

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

class Converters {

    //ATTRIBUTES
    @TypeConverter
    fun fromIntermediaryAttribute(attribute: IntermediaryAttribute): CustomAttribute {
        return when(attribute.type) {
            AttributeType.Number -> CustomAttribute.NumberAttribute(attribute.attributeId, attribute.attributeTitle, attribute.attributeValue.toFloat())
            AttributeType.Text -> CustomAttribute.TextAttribute(attribute.attributeId, attribute.attributeTitle, attribute.attributeValue)
            AttributeType.Card -> CustomAttribute.CardAttribute(attribute.attributeId, attribute.attributeTitle, attribute.attributeValue.toInt())
        }
    }

    @TypeConverter
    fun toIntermediaryAttribute(attribute: CustomAttribute.NumberAttribute): IntermediaryAttribute {
        return IntermediaryAttribute(attribute.attributeId,  attribute.attributeTitle, attribute.value.toString(), AttributeType.Number )
    }

    @TypeConverter
    fun toIntermediaryAttribute(attribute: CustomAttribute.TextAttribute): IntermediaryAttribute {
        return IntermediaryAttribute(attribute.attributeId,  attribute.attributeTitle, attribute.value, AttributeType.Text )
    }

    @TypeConverter
    fun toIntermediaryAttribute(attribute: CustomAttribute.CardAttribute): IntermediaryAttribute {
        return IntermediaryAttribute(attribute.attributeId,  attribute.attributeTitle, attribute.value.toString(), AttributeType.Card )
    }

    //CATEGORIES
    @TypeConverter
    fun fromIntermediaryCategory(category: IntermediaryCategory): CustomCategory {
        return when(category.type) {
            CategoryType.MultiAttributes -> CustomCategory.MultiAttributesCategory(category.categoryId, category.categoryTitle, emptyList())
            CategoryType.SingleAttribute -> CustomCategory.SingleAttributeCategory(category.categoryId, category.categoryTitle, CustomAttribute.TextAttribute(0,"",""))
            CategoryType.Cards -> CustomCategory.CardsCategory(category.categoryId, category.categoryTitle, emptyList())
        }
    }

    @TypeConverter
    fun toIntermediaryCategory(category: CustomCategory.MultiAttributesCategory): IntermediaryCategory {
        return IntermediaryCategory(category.categoryId, category.categoryTitle, CategoryType.MultiAttributes )
    }

    @TypeConverter
    fun toIntermediaryCategory(category: CustomCategory.SingleAttributeCategory): IntermediaryCategory {
        return IntermediaryCategory(category.categoryId, category.categoryTitle, CategoryType.SingleAttribute )
    }

    @TypeConverter
    fun toIntermediaryCategory(category: CustomCategory.CardsCategory): IntermediaryCategory {
        return IntermediaryCategory(category.categoryId, category.categoryTitle, CategoryType.Cards )
    }

    //CARD
    @TypeConverter
    fun fromIntermediaryCard(card: IntermediaryCard): Card {
        return when(card.type) {
            CardType.MultiCategory ->Card.MultiCategoryCard(card.cardId, card.cardTitle, card.cardImage, emptyList())
            CardType.Collection ->Card.MultiCategoryCard(card.cardId, card.cardTitle, card.cardImage, emptyList())
        }
    }

    @TypeConverter
    fun toIntermediaryCard(card: Card.MultiCategoryCard): IntermediaryCard {
        return IntermediaryCard(card.cardId, card.cardTitle, card.cardImage, CardType.MultiCategory)
    }

    @TypeConverter
    fun toIntermediaryCard(card: Card.CollectionCard): IntermediaryCard {
        return IntermediaryCard(card.cardId, card.cardTitle, card.cardImage, CardType.Collection)
    }
}