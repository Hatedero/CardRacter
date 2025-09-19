package com.retardero.cardracter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.R
import com.retardero.cardracter.ui.theme.Primary
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