package com.retardero.cardracter.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.R

@Composable
fun AccountPicture(illustration : Int=R.drawable.default_pp, tranparency : Float = 1f){
    Box() {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(10000.dp))
                .fillMaxHeight(0.3f).aspectRatio(1f),
            alpha = tranparency,
            painter = painterResource(illustration),
            contentDescription = "profile picture",
            contentScale = ContentScale.Crop,
        )
        if(tranparency<1f){
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(10000.dp))
                    .fillMaxHeight(0.3f).aspectRatio(1f),
                alpha = tranparency,
                painter = painterResource(illustration),
                contentDescription = "profile picture",
                contentScale = ContentScale.Crop,
            )
        }
    }
}