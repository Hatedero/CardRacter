package com.retardero.cardracter.data.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.navargs.NavTypeSerializer
import com.retardero.cardracter.R
import com.retardero.cardracter.data.attribute.CardAttribute
import com.retardero.cardracter.data.category.user.CardListCategory
import com.retardero.cardracter.data.category.CustomCategory
import com.retardero.cardracter.data.category.base.CardCategory
import com.retardero.cardracter.data.category.base.CharacterCardCategory
import com.retardero.cardracter.data.category.user.LongTextCategory
import com.retardero.cardracter.data.category.user.TextListCategory
import com.retardero.cardracter.ui.theme.Primary

class CharacterCard(
    cardAttributes: CardCategory,
    characterAttributes: CharacterCardCategory
) : Card(cardAttributes) {

    var characterAttributes: CharacterCardCategory = characterAttributes

    @Composable
    override fun Draw() {
        return Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(attributes.cardIllustration),
                    contentDescription = "icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxHeight()
                )
            }
            Column(
                Modifier.fillMaxSize(),
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(attributes.cardTitle, fontWeight = FontWeight.Bold, fontSize = 40.sp, textAlign = TextAlign.Center, color = Primary)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(attributes.cardDescription, fontSize = 15.sp, textAlign = TextAlign.Justify, color = Color.DarkGray)
                }

                Spacer(modifier = Modifier.height(32.dp))

                attributes.cardCategories?.forEach { it ->
                    it.draw()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }


    companion object {
        fun empty(): CharacterCard = CharacterCard(
            cardAttributes = CardCategory.empty(),
            characterAttributes = CharacterCardCategory.empty()
        )

        fun testData(): CharacterCard = CharacterCard(
            cardAttributes = CardCategory.testData(),
            characterAttributes = CharacterCardCategory.testData()
        )
    }

}