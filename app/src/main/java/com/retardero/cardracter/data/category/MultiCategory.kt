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
import com.retardero.cardracter.data.attribute.CardAttribute
import com.retardero.cardracter.data.attribute.CustomAttribute
import com.retardero.cardracter.data.card.CharacterCard
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.data.category.base.CardCategory
import com.retardero.cardracter.data.category.base.CharacterCardCategory

abstract class MultiCategory(
    attributes: List<CustomAttribute>,
    title: String = "Empty Category"
) : CustomCategory(title) {

    var attributes: List<CustomAttribute> = attributes

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
                attributes.forEach { attribute ->
                    Spacer(modifier = Modifier.width(4.dp))
                    attribute.draw()
                }
            }
        }
    }

    companion object {
        /*fun testData(): CustomCategory = MultiCategory(
            title = "Foes",
            attributes = listOf(CardAttribute("", CharacterCard(CardCategory.empty(), CharacterCardCategory.empty()))),
        )*/
    }

}