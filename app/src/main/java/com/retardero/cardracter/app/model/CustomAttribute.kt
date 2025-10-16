package com.retardero.cardracter.app.model

sealed class CustomAttribute (
    val id: Int,
    val title: String
) {
    data class NumberAttribute(
        val attributeId: Int,
        val cardTitle: String,
        val value: Float
    ) : CustomAttribute(attributeId, cardTitle) {

    }

    data class TextAttribute(
        val attributeId: Int,
        val cardTitle: String,
        val value: String
    ) : CustomAttribute(attributeId, cardTitle) {

    }

    data class CardAttribute(
        val attributeId: Int,
        val cardTitle: String,
        val value: Int
    ) : CustomAttribute(attributeId, cardTitle) {

    }
}