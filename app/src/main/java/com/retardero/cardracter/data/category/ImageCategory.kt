package com.retardero.cardracter.data.category

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.R
import com.retardero.cardracter.data.attribute.CustomAttribute
import com.retardero.cardracter.data.attribute.ImageAttribute
import com.retardero.cardracter.ui.theme.Primary

class ImageCategory(
    attributes: List<CustomAttribute> = emptyList(),
    title: String = "No image provided",
) : CustomCategory(attributes, title)  {

    @Composable
    override fun draw() {
        return Column(
            modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(1.dp, Primary),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(8.dp) )
            {
                Text(title)
                attributes.forEach { it ->
                    Spacer(modifier = Modifier.height(4.dp))
                    it.draw()
                }
            }
    }

    companion object {
        fun testData(): CustomCategory = ImageCategory(
            title = "The good days",
            attributes = listOf(
                ImageAttribute("The good days",R.drawable.default_pp)
            )
        )
        fun testData2(): CustomCategory = ImageCategory(
            title = "My Dix coslpay",
            attributes = listOf(
                ImageAttribute.testData()
            )
        )
        fun testData3(): CustomCategory = ImageCategory(
            title = "The good days",
            attributes = listOf(
                ImageAttribute.testData(),
                ImageAttribute.testData2(),
            )
        )
    }
}