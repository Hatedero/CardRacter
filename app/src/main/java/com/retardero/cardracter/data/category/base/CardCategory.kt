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
import com.ramcosta.composedestinations.navargs.NavTypeSerializer
import com.retardero.cardracter.R
import com.retardero.cardracter.data.attribute.CustomAttribute
import com.retardero.cardracter.data.attribute.LongTextAttribute
import com.retardero.cardracter.data.category.CustomCategory
import com.retardero.cardracter.data.category.MultiCategory
import com.retardero.cardracter.data.category.user.CardListCategory
import com.retardero.cardracter.data.category.user.LongTextCategory
import com.retardero.cardracter.data.category.user.TextListCategory
import com.retardero.cardracter.ui.theme.Primary

class CardCategory  (
    CategoryTitle: String = "Card informations",
    attributes: List<CustomAttribute> = emptyList(),

    cardTitle: String = "Title",
    cardDescription: String = "Description",
    cardIllustration: Int = R.drawable.default_pp,
    cardCategories: List<CustomCategory> = emptyList()
) : MultiCategory(attributes, CategoryTitle) {

    var cardTitle: String = cardTitle
    var cardDescription: String = cardDescription
    var cardIllustration: Int = cardIllustration
    var cardCategories: List<CustomCategory>? = cardCategories

    companion object {
        fun empty(): CardCategory = CardCategory(
            cardTitle = "",
            cardDescription = "",
            cardIllustration = R.drawable.default_pp,
        )

        fun testData(): CardCategory = CardCategory(
            cardTitle = "Artorias Pyrii",
            cardDescription = "A knight promised to save the world.",
            cardIllustration = R.drawable.artorias,
            cardCategories = listOf(
                TextListCategory.testData(),
                LongTextCategory.testData(),
                CardListCategory.testData()
            )
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