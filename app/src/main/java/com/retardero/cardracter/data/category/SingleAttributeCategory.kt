package com.retardero.cardracter.data.category

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.data.attribute.CustomAttribute
import com.retardero.cardracter.ui.theme.Primary

abstract class SingleAttributeCategory(
    attribute: CustomAttribute,
    title: String = "Empty Category"
) : CustomCategory(title) {

    var attribute: CustomAttribute = attribute

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
            Spacer(modifier = Modifier.width(16.dp))
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState())
                    .padding(16.dp)
                    .height(200.dp)
            ) {
                    Spacer(modifier = Modifier.width(4.dp))
                    attribute.draw()
            }
        }
    }

    companion object {
        /*fun testData(): CustomCategory = SingleCategory(
            title = "Foes",
            attribute = CardAttribute("", CharacterCard(CardCategory.empty(), CharacterCardCategory.empty())),
        )*/
    }

}