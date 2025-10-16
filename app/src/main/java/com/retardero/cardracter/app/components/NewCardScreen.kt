package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import android.content.ClipData.Item
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
import com.retardero.cardracter.data.card.Card
import com.retardero.cardracter.data.card.Card.MultiCategoryCard
import com.retardero.cardracter.data.card.Card.MultiCategoryCard.CharacterCard
import com.retardero.cardracter.destinations.CardDetailScreenDestination
import com.retardero.cardracter.ui.EditTopBar
import com.retardero.cardracter.ui.FloatingActionMenuEditCard
import com.retardero.cardracter.ui.FullScaleMCDVisual
import com.retardero.cardracter.ui.theme.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
@Composable
fun NewCardScreen(
    navigator: DestinationsNavigator,
    card: MultiCategoryCard = CharacterCard.testData()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionMenuEditCard({ navigator.navigate(CardDetailScreenDestination) }, { navigator.navigateUp() })
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