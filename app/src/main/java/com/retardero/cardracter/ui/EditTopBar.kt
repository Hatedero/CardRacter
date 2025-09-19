package com.retardero.cardracter.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.ui.theme.Primary

@Composable
fun EditTopBar() {
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
                .clip(RoundedCornerShape(10.dp))
                .clickable {  }
        )

        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "icon",
            tint = Primary,
            modifier = Modifier.fillMaxHeight()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .clickable {  }
        )
    }
}