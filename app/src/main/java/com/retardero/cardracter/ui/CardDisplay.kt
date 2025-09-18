package com.retardero.cardracter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.data.card.Card
import com.retardero.cardracter.data.card.CharacterCard
import com.retardero.cardracter.ui.theme.Primary

@Preview(showBackground = true)
@Composable
fun CardDisplay(card : Card = CharacterCard.empty()) {
    var backgroundColor by remember { mutableStateOf(Color.LightGray) }

    Column (
        modifier = Modifier.clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .clickable {
                backgroundColor = if (backgroundColor == Color.LightGray) Color.DarkGray else Color.LightGray
            }
    ) {
        Image(
            painter = painterResource(card.illustration!!),
            contentDescription = "icon",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
        )
        Column (
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(card.title!!, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, color = Primary, fontSize = 20.sp)
            Text(card.description!!, color = Primary, fontSize = 10.sp)
        }
    }
}