package com.retardero.cardracter.data.attribute

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class IntAttribute(
    title: String?,
    value: Int?
) : CustomAttribute(title) {
    var value: Int? = value

    companion object {
        fun testData(): IntAttribute = IntAttribute(
            "Strength",
            10
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