package com.retardero.cardracter.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.destinations.AccountScreenDestination
import com.retardero.cardracter.ui.theme.Primary

@Composable
fun ActionLogo(drawable : Int, toDo: () -> Unit, description : String = "login/sign up button"){
    Box(
        modifier = Modifier.clip(CircleShape)
        .background(Primary)
        .width(80.dp)
        .height(80.dp)
        .clickable { toDo() }
    ) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(10000.dp))
                .fillMaxSize().aspectRatio(1f),
            painter = painterResource(drawable),
            contentDescription = description,
            contentScale = ContentScale.Crop,
        )
    }
}