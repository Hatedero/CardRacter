package com.retardero.cardracter.collections.model

sealed class ModifiableCustomAttribute (
    var id: Int,
    var title: String
) {
    abstract fun returnValue(): String
    abstract fun <T> setValue(newValue : T): Boolean
    abstract fun <T> copy(id: Int? = null, title: String? = null, value: T? = null): ModifiableCustomAttribute

    data class ModifiableNumberAttribute(
        var attributeId: Int,
        var attributeTitle: String,
        var value: Float
    ) : ModifiableCustomAttribute(attributeId, attributeTitle) {
        override fun returnValue(): String {
            return value.toString()
        }

        override fun <T> setValue(newValue : T): Boolean {
            this.value = newValue as Float
            return true
        }

        override fun <T> copy(id: Int?, title: String?, value: T?): ModifiableCustomAttribute {
            return ModifiableNumberAttribute(id ?: attributeId, title ?: attributeTitle, (value ?: this.value) as Float)
        }
    }

    data class ModifiableTextAttribute(
        var attributeId: Int,
        var attributeTitle: String,
        var value: String
    ) : ModifiableCustomAttribute(attributeId, attributeTitle) {
        override fun returnValue(): String {
            return value.toString()
        }

        override fun <T> setValue(newValue : T): Boolean {
            this.value = newValue as String
            return true
        }

        override fun <T> copy(id: Int?, title: String?, value: T?): ModifiableCustomAttribute {
            return ModifiableTextAttribute(id ?: attributeId, title ?: attributeTitle, (value ?: this.value).toString())
        }
    }

    data class ModifiableCardAttribute(
        var attributeId: Int,
        var attributeTitle: String,
        var value: Int
    ) : ModifiableCustomAttribute(attributeId, attributeTitle) {
        override fun returnValue(): String {
            return value.toString()
        }

        override fun <T> setValue(newValue : T): Boolean {
            this.value = newValue as Int
            return true
        }

        override fun <T> copy(id: Int?, title: String?, value: T?): ModifiableCustomAttribute {
            return ModifiableCardAttribute(id ?: attributeId, title ?: attributeTitle, (value ?: this.value) as Int)
        }
    }
}