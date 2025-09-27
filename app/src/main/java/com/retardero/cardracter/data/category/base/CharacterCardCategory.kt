package com.retardero.cardracter.data.category.base

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
import com.retardero.cardracter.data.category.MultiAttributesCategory
import com.retardero.cardracter.ui.theme.Primary

class CharacterCardCategory  (
    categoryTitle: String = "Card informations",
    attributes: List<CustomAttribute> = emptyList(),

    cardAttributes: CardCategory,

    characterAge: String,
    characterProverb: String
) : MultiAttributesCategory(attributes, categoryTitle) {

    var characterAge: String = characterAge
    var characterProverb: String = characterProverb

    companion object {
        fun empty(): CharacterCardCategory = CharacterCardCategory(
            cardAttributes = CardCategory.empty(),
            characterAge = "",
            characterProverb = ""
        )

        fun testData(): CharacterCardCategory = CharacterCardCategory(
            categoryTitle = "Character informations",
            cardAttributes = CardCategory.testData(),
            characterAge = "42",
            characterProverb = "I beg of thee, the spread of the abyss, must be stopped. "
        )
    }

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

}