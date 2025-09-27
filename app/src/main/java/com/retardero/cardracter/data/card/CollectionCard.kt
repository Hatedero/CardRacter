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
import com.retardero.cardracter.data.attribute.CardAttribute
import com.retardero.cardracter.data.category.SingleAttributeCategory
import com.retardero.cardracter.data.category.base.CardCategory
import com.retardero.cardracter.data.category.base.CharacterCardCategory
import com.retardero.cardracter.data.category.user.CardListCategory
import com.retardero.cardracter.ui.theme.Primary

class CollectionCard(
    cardAttributes: CardCategory,
    cards: CardListCategory,
) : Card(cardAttributes) {

    var cards: CardListCategory = cards

    @Composable
    override fun DrawFullScale() {
        return Column() {
            cards.attributes.forEach { it->
                it.draw()
            }
        }
    }

    @Composable
    override fun DrawSimplified() {
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