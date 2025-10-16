package com.retardero.cardracter.app.model

sealed class CustomAttribute (
    val id: Int,
    val title: String
) {
    data class NumberAttribute(
        val attributeId: Int,
        val attributeTitle: String,
        val value: Float
    ) : CustomAttribute(attributeId, attributeTitle) {

    }

    data class TextAttribute(
        val attributeId: Int,
        val attributeTitle: String,
        val value: String
    ) : CustomAttribute(attributeId, attributeTitle) {

    }

    data class CardAttribute(
        val attributeId: Int,
        val attributeTitle: String,
        val value: Int
    ) : CustomAttribute(attributeId, attributeTitle) {

    }
}