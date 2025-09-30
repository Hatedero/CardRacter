package com.retardero.cardracter.app.model.attribute

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class TextAttribute(
    title: String?,
    value: String?
) : com.retardero.cardracter.app.model.attribute.CustomAttribute(title) {
    var value: String? = value

    companion object {
        fun testData(): com.retardero.cardracter.app.model.attribute.TextAttribute =
            com.retardero.cardracter.app.model.attribute.TextAttribute(
                "Mother",
                "Alice Deane"
            )
    }

    @Composable
    override fun draw() {
        return Row (

        ) {
            Text("$title : $value")
        }
    }
}