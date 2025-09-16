package com.retardero.cardracter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.R
import com.retardero.cardracter.ui.theme.Primary

@Preview(showBackground = true)
@Composable
fun CardDisplay(title : String? = "Name Firstname") {
    Column (
        modifier = Modifier.clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(R.drawable.default_pp),
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
            Text(title!!, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, color = Primary, fontSize = 20.sp)
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec fermentum.", color = Primary)
        }
    }
}