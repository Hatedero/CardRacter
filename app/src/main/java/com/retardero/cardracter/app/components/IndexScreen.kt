package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.retardero.cardracter.data.card.CharacterCard
import com.retardero.cardracter.ui.CardDisplay
import com.retardero.cardracter.ui.NavBar
import com.retardero.cardracter.ui.ProfileTab
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
@Preview(showBackground = true)
@Composable
fun IndexScreen() {
    Scaffold (
        bottomBar = { NavBar() },
        topBar = { ProfileTab() },
        modifier = Modifier.padding(16.dp)
            .background(Background)
    ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 8.dp,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                for(i in 1..50) {
                    item {
                        if(i % 2 == 0) CardDisplay(CharacterCard("Ornstein - The Dragon Slayer", "", R.drawable.ornstein))
                        else CardDisplay(CharacterCard.testData())
                    }
                }
            }
        }
}