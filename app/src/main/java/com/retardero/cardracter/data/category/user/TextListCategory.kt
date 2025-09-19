package com.retardero.cardracter.data.category.user

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.data.attribute.CustomAttribute
import com.retardero.cardracter.data.attribute.TextAttribute
import com.retardero.cardracter.data.category.CustomCategory
import com.retardero.cardracter.ui.theme.Primary

class TextListCategory(
    attributes: List<CustomAttribute> = emptyList(),
    title: String = "Empty Category"
) : CustomCategory(attributes, title) {

    @Composable
    override fun draw() {

        return Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    border = BorderStroke(1.dp, Primary),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(8.dp)
        ) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 25.sp)
            attributes.forEach { it ->
                Spacer(modifier = Modifier.height(4.dp))
                it.draw()
            }
        }
    }

    companion object {
        fun testData(): CustomCategory = TextListCategory(
            title = "Family",
            attributes = listOf(
                TextAttribute("Mother", "Alice Dean"),
                TextAttribute("Father", "Tom Ward"),
                TextAttribute("Brother", "Ornstein Pyrii"),
                TextAttribute("Spouse", "Linthia Stagerman")
                )
        )
    }

}