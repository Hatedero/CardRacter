package com.retardero.cardracter.data.attribute

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class NumberAttribute(
    title: String?,
    value: Float?
) : CustomAttribute(title) {
    var value: Float? = value

    companion object {
        fun testData(): NumberAttribute = NumberAttribute(
            "Strength",
            10.0f
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