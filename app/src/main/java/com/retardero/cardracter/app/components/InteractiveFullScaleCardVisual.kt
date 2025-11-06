package com.retardero.cardracter.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.R
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.model.CustomCategory
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary


@Composable
fun InteractiveFullScaleCardVisual(baseCard: Card) {

    return when (baseCard) {
        is Card.MultiCategoryCard -> {
            var card by remember { mutableStateOf(baseCard) }

            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.artorias),
                        contentDescription = "icon",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxHeight()
                            .clickable { card = card.copy(cardAttributes = emptyList()) }
                    )
                }
                Column(
                    Modifier.fillMaxSize(),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CardTitleTextField(card.cardTitle, { card = card.copy(cardTitle = it) })
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    card.cardAttributes.forEachIndexed { i, category ->
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            /*Text(
                                category.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                textAlign = TextAlign.Left,
                                color = Primary
                            )*/
                            var modifiedCategories = mutableListOf<CustomCategory>()
                            modifiedCategories.addAll(card.cardAttributes)

                            CardSubTitleTextField(category.title, { change -> card = card.copy(cardAttributes = card.cardAttributes.toMutableList().also { it[i] = card.cardAttributes.get(i).copy(title = change)}) })
                            when (category) {
                                is CustomCategory.MultiAttributesCategory ->
                                    category.attributes.forEach { attribute ->
                                        Text(
                                            attribute.returnValue(),
                                            fontSize = 20.sp,
                                            textAlign = TextAlign.Left,
                                        )
                                    }

                                is CustomCategory.SingleAttributeCategory ->
                                    Text(
                                        category.attribute.returnValue(),
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.Left,
                                    )

                                is CustomCategory.CardsCategory -> {}
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }

         else -> {

         }
    }
}