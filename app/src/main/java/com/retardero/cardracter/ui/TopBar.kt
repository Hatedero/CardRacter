package com.retardero.cardracter.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.retardero.cardracter.ui.theme.Primary

@Composable
fun TopBar() {
    Row (
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(0.04f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "icon",
            tint = Primary,
            modifier = Modifier.fillMaxHeight()
                .aspectRatio(1f)
        )

        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "icon",
            tint = Primary,
            modifier = Modifier.fillMaxHeight()
                .aspectRatio(1f)
        )
    }
}