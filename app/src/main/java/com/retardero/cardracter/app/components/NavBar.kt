package com.retardero.cardracter.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.destinations.CollectionsScreenDestination
import com.retardero.cardracter.destinations.IndexScreenDestination
import com.retardero.cardracter.destinations.SearchScreenDestination
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.PrimaryContainer

@Destination
@Composable
fun NavBar(navigator: DestinationsNavigator, index : List<ImageVector>? = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.Favorite)) {
        Row(
            modifier = Modifier.clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.08f)

                .background(Color.LightGray)
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {/*
            index?.forEach { icon ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100))
                        .clickable {  }
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
            }*/

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .clickable { navigator.navigate(IndexScreenDestination) }
                    .background(PrimaryContainer)
                    .padding(7.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "icon",
                    tint = Primary,
                    modifier = Modifier.fillMaxHeight()
                        .aspectRatio(1f)
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .clickable { navigator.navigate(SearchScreenDestination)  }
                    .background(PrimaryContainer)
                    .padding(7.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "icon",
                    tint = Primary,
                    modifier = Modifier.fillMaxHeight()
                        .aspectRatio(1f)
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .clickable { navigator.navigate(CollectionsScreenDestination)  }
                    .background(PrimaryContainer)
                    .padding(7.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "icon",
                    tint = Primary,
                    modifier = Modifier.fillMaxHeight()
                        .aspectRatio(1f)
                )
            }
    }
}