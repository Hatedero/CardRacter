package com.retardero.cardracter.data.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.retardero.cardracter.data.category.CustomCategory
import com.retardero.cardracter.data.category.base.CardCategory
import com.retardero.cardracter.data.category.base.CharacterCardCategory
import com.retardero.cardracter.data.category.user.CardListCategory
import com.retardero.cardracter.ui.theme.Primary

sealed class Card (
    var attributes: CardCategory
) {

    data class CollectionCard(
        val cardAttributes: CardCategory,
        val cards: CardListCategory,
    ) : Card(cardAttributes) {

        @Composable
        fun DrawFullScale() {
            return Column() {
                cards.cards.forEach { it->
                    it.draw()
                }
            }
        }

        companion object {
            fun empty(): CollectionCard = CollectionCard(
                cardAttributes = CardCategory.empty(),
                cards = CardListCategory.empty()
            )

            fun testData(): CollectionCard = CollectionCard(
                cardAttributes = CardCategory(
                    cardTitle = "Favorites"
                ),
                cards = CardListCategory.testData()
            )
        }
    }


    sealed class MultiCategoryCard(
        val cardAttributes: CardCategory,
        val categories: List<CustomCategory>? = emptyList()
    ) : Card(cardAttributes) {

        @Composable
        fun DrawFullScale() {
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

        @Composable
        fun DrawSimplified() {
            var backgroundColor by remember { mutableStateOf(Color.LightGray) }

            Column (
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    .background(backgroundColor)
                    .clickable(
                        onClick = {}
                    )
                    .fillMaxHeight()
                    .aspectRatio(0.6f)

            ) {
                Row (
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight(0.6f)
                ) {
                    Image(
                        painter = painterResource(attributes.cardIllustration),
                        contentDescription = "icon",
                        contentScale = ContentScale.Crop,
                    )
                }
                Column (
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    var fontSize by remember {
                        mutableStateOf(20.sp)
                    }

                    Text(attributes.cardTitle, maxLines = 2,
                        fontSize = fontSize,
                        onTextLayout = {
                            if (it.multiParagraph.didExceedMaxLines) {
                                fontSize = fontSize * .9F
                            }
                        },
                        fontWeight = FontWeight.Bold)
                    Text(attributes.cardDescription, color = Primary, fontSize = 10.sp)
                }
            }
        }

        data class CharacterCard(
            val characterAttributes: CharacterCardCategory,
            val cardBaseAttributes: CardCategory
        ) : MultiCategoryCard(cardBaseAttributes) {

            //val characterAttributes: CharacterCardCategory = characterAttributes

            companion object {
                fun empty(): CharacterCard = CharacterCard(
                    cardBaseAttributes = CardCategory.empty(),
                    characterAttributes = CharacterCardCategory.empty()
                )

                fun testData(): CharacterCard = CharacterCard(
                    cardBaseAttributes = CardCategory.testData(),
                    characterAttributes = CharacterCardCategory.testData()
                )
            }

        }
    }
}