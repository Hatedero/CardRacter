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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.ui.theme.Primary

@Preview(showBackground = true)
@Composable
fun SeachTopBar() {
    Row (
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(0.04f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        var search by remember { mutableStateOf("knightly knight") }

        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "icon",
            tint = Primary,
            modifier = Modifier.fillMaxHeight()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .clickable {  }
        )

        TextField(
            value = search,
            onValueChange = {
                search = it
            },
            modifier = Modifier.fillMaxHeight()
                .fillMaxHeight()
        )

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "icon",
            tint = Primary,
            modifier = Modifier.fillMaxHeight()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .clickable {  }
        )
    }
}