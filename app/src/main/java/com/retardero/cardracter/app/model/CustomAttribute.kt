package com.retardero.cardracter.app.model

sealed class CustomAttribute (
    val id: Int,
    val title: String
) {
    abstract fun returnValue(): String
    abstract fun <T> copy(id: Int? = null, title: String? = null, value: T? = null): CustomAttribute

    data class NumberAttribute(
        val attributeId: Int,
        val attributeTitle: String,
        val value: Float
    ) : CustomAttribute(attributeId, attributeTitle) {
        override fun returnValue(): String {
            return value.toString()
        }

        override fun <T> copy(id: Int?, title: String?, value: T?): CustomAttribute {
            return NumberAttribute(id ?: attributeId, title ?: attributeTitle, (value ?: this.value) as Float)
        }
    }

    data class TextAttribute(
        val attributeId: Int,
        val attributeTitle: String,
        val value: String
    ) : CustomAttribute(attributeId, attributeTitle) {
        override fun returnValue(): String {
            return value.toString()
        }

        override fun <T> copy(id: Int?, title: String?, value: T?): CustomAttribute {
            return TextAttribute(id ?: attributeId, title ?: attributeTitle, (value ?: this.value).toString())
        }
    }

    data class CardAttribute(
        val attributeId: Int,
        val attributeTitle: String,
        val value: Int
    ) : CustomAttribute(attributeId, attributeTitle) {
        override fun returnValue(): String {
            return value.toString()
        }

        override fun <T> copy(id: Int?, title: String?, value: T?): CustomAttribute {
            return CardAttribute(id ?: attributeId, title ?: attributeTitle, (value ?: this.value) as Int)
        }
    }
}