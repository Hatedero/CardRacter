package com.retardero.cardracter.app.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.R
import com.retardero.cardracter.ui.theme.Primary

@Composable
fun CardRacterBanner(drawable: Int = R.drawable.dix_yeux){
    Row (
        modifier = Modifier.background(Primary)
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(drawable),
            contentDescription = "Google signUp button",
            contentScale = ContentScale.Crop,
        )
    }
}