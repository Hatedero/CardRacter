package com.retardero.cardracter.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.retardero.cardracter.R
import com.retardero.cardracter.ui.theme.Secondary

@Composable
fun ProfileTab() {
    Box (
        modifier = Modifier.clip(RoundedCornerShape(100))
            .clickable {  }
            .background(Secondary)
    ) {
        Image(
            painter = painterResource(R.drawable.default_pp),
            contentDescription = "icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth(0.15f)
                .aspectRatio(1f)
        )
    }
}