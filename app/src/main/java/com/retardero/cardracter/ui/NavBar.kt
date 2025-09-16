package com.retardero.cardracter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.PrimaryContainer
import com.retardero.cardracter.ui.theme.Secondary

@Preview(showBackground = true)
@Composable
fun NavBar(index : List<ImageVector>? = listOf<ImageVector>(Icons.Default.Home, Icons.Default.Search, Icons.Default.Favorite)) {
    Row (
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(0.08f)
        ,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.clip(RoundedCornerShape(15.dp))
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            index?.forEach { icon ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100))
                        .background(PrimaryContainer)
                        .padding(7.dp)
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "icon",
                        tint = Primary,
                        modifier = Modifier.fillMaxHeight()
                            .aspectRatio(1f)
                    )
                }

            }
        }
    }
}