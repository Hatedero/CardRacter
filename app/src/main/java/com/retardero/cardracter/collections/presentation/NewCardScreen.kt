package com.retardero.cardracter.collections.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.app.components.EditTopBar
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.components.FloatingActionMenuEditCard
import com.retardero.cardracter.app.components.FullScaleMCDVisual
import com.retardero.cardracter.ui.theme.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
@Composable
fun NewCardScreen(
    navigator: DestinationsNavigator,
    card: Card.MultiCategoryCard = Card.MultiCategoryCard.empty()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionMenuEditCard({ navigator.navigateUp() }, { navigator.navigateUp() })
        },
        topBar = {
            EditTopBar(
                { navigator.navigateUp() },
                { }
            )
        },
        modifier = Modifier
            .padding(16.dp)
            .background(Background)
    ) {
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            item { FullScaleMCDVisual(card) }
        }
    }
}