package com.retardero.cardracter.ui

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
import com.retardero.cardracter.data.card.Card
import com.retardero.cardracter.ui.theme.Primary

@Composable
fun SimplifiedMCDVisual(card: Card.MultiCategoryCard) {
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
                painter = painterResource(card.attributes.cardIllustration),
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

            Text(card.attributes.cardTitle, maxLines = 2,
                fontSize = fontSize,
                onTextLayout = {
                    if (it.multiParagraph.didExceedMaxLines) {
                        fontSize = fontSize * .9F
                    }
                },
                fontWeight = FontWeight.Bold)
            Text(card.attributes.cardDescription, color = Primary, fontSize = 10.sp)
        }
    }
}


@Composable
fun fullScaleMCDVisual(card: Card.MultiCategoryCard) {
    return Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(card.attributes.cardIllustration),
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
                Text(card.attributes.cardTitle, fontWeight = FontWeight.Bold, fontSize = 40.sp, textAlign = TextAlign.Center, color = Primary)
                Spacer(modifier = Modifier.height(8.dp))
                Text(card.attributes.cardDescription, fontSize = 15.sp, textAlign = TextAlign.Justify, color = Color.DarkGray)
            }

            Spacer(modifier = Modifier.height(32.dp))

            card.attributes.cardCategories?.forEach { it ->
                it.draw()
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
