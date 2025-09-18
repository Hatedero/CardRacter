package com.retardero.cardracter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.retardero.cardracter.data.card.Card
import com.retardero.cardracter.data.card.CharacterCard
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary
import java.nio.file.WatchEvent

@Preview(showBackground = true)
@Composable
fun CardDisplay(card : Card = CharacterCard.empty()) {
    var backgroundColor by remember { mutableStateOf(Color.LightGray) }

    Column (
        modifier = Modifier.clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .clickable {
            }
            .fillMaxHeight()
            .aspectRatio(0.6f)

    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(0.6f)
        ) {
            Image(
                painter = painterResource(card.illustration!!),
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

            Text(card.title!!, maxLines = 2,
                fontSize = fontSize,
                onTextLayout = {
                    if (it.multiParagraph.didExceedMaxLines) {
                        fontSize = fontSize * .9F
                    }
                })
            Text(card.description!!, color = Primary, fontSize = 10.sp)
        }
    }
}