package com.retardero.cardracter.data.attribute

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class TextAttribute(
    title: String?,
    value: String?
) : CustomAttribute(title) {
    var value: String? = value

    companion object {
        fun testData(): TextAttribute = TextAttribute(
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