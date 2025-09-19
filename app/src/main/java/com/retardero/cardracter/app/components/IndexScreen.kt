package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.data.card.CharacterCard
import com.retardero.cardracter.ui.CardDisplay
import com.retardero.cardracter.ui.NavBar
import com.retardero.cardracter.ui.ProfileTab
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.R
import com.retardero.cardracter.app.components.destinations.CardDetailScreenDestination
import com.retardero.cardracter.ui.SeachTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination(start = true)
//@Preview(showBackground = true)
@Composable
fun IndexScreen(navigator: DestinationsNavigator) {
    Scaffold (
        bottomBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, RoundedCornerShape(8.dp))
            ) {
            NavBar()} },
        topBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, CircleShape)
            ) {
                ProfileTab()
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
                        if(i % 2 == 0) CardDisplay(CharacterCard("Ornstein - The Dragon Slayer", "A knight guarding the royal city of Anor Londo.", R.drawable.ornstein),
                            {
                            navigator.navigate(CardDetailScreenDestination())
                        })
                        else CardDisplay(CharacterCard.testData(), {
                            navigator.navigate(CardDetailScreenDestination())})
                    }
                }
            }
        }
}

