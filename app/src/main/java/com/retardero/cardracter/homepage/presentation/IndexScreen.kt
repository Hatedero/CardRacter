package com.retardero.cardracter.homepage.presentation

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.app.model.card.Card
import com.retardero.cardracter.homepage.domain.IndexViewModel
import com.retardero.cardracter.app.components.NavBar
import com.retardero.cardracter.app.components.ProfileTab
import com.retardero.cardracter.ui.theme.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination (start = true)
@Composable
fun IndexScreen(navigator: DestinationsNavigator, viewModel: IndexViewModel = viewModel()) {

    val card: Card by viewModel.characterCard.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCards()
    }

    Scaffold (
        bottomBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, RoundedCornerShape(20.dp))
            ) {
            NavBar(navigator)
            } },
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
                        card.DrawSimplified()
                    }
                }
            }
        }
}

