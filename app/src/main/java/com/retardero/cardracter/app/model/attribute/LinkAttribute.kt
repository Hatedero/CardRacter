package com.retardero.cardracter.app.model.attribute

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class LinkAttribute(
    title: String?,
    value: CustomAttribute?
) : CustomAttribute(title) {
    var value: CustomAttribute? = value

    companion object {
        fun testData(): LinkAttribute = LinkAttribute(
            "Mother",
            com.retardero.cardracter.app.model.attribute.TextAttribute("test", "test")
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