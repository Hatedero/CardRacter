package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.ui.ProfileTab
import com.retardero.cardracter.ui.theme.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination(start=true)
@Composable
fun IndexScreen(navigator: DestinationsNavigator) {
    Scaffold (
        bottomBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, RoundedCornerShape(20.dp))
            ) {
            NavBar(navigator)} },
        topBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, CircleShape)
            ) {
                ProfileTab(navigator)
            }},
        modifier = Modifier.padding(8.dp)
            .background(Background)
    ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 8.dp,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                for(i in 1..50) {
                    item {
                         // draw all cards
                    }
                }
            }
        }
}

