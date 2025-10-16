package com.retardero.cardracter.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.data.card.Card
import com.retardero.cardracter.data.card.Card.CollectionCard
//import com.retardero.cardracter.data.card.CollectionCard
import com.retardero.cardracter.ui.theme.Secondary

//@Preview(showBackground = true)
@Composable
fun CollectionDisplay(collection : CollectionCard = CollectionCard.testData(), navigate: () -> Unit) {

    Column(
        modifier = Modifier.clip(RoundedCornerShape(10.dp))
            .background(Secondary)
            .clickable(
                onClick = navigate
            )
            .fillMaxWidth()
            .height(100.dp)
            .padding(2.dp)
    ) {
        Text(collection.attributes.cardTitle, fontWeight = FontWeight.Bold)
        Row (
            modifier = Modifier.padding(2.dp)
        ) {
            collection.DrawFullScale()
        }
    }
}