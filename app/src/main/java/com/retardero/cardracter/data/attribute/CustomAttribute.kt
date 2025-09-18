package com.retardero.cardracter.data.attribute

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class CustomAttribute (
    var value: String?,
    var title: String?
) {

    @Composable
    fun draw() {
        return Text("$title : $value")
    }

    companion object {
        fun testData(): CustomAttribute = CustomAttribute(
            "value",
            "title"
        )
    }
}