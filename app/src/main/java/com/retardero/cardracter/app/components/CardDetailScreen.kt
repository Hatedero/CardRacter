package com.retardero.cardracter.app.components

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
import com.retardero.cardracter.data.card.Card
import com.retardero.cardracter.data.card.CharacterCard
import com.retardero.cardracter.ui.NavBar
import com.retardero.cardracter.ui.EditTopBar
import com.retardero.cardracter.ui.theme.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
@Composable
fun CardDetailScreen (navigator: DestinationsNavigator, card : Card = CharacterCard.testData()) {
    Scaffold (
        bottomBar = { NavBar(navigator) },
        topBar = { EditTopBar(
            { navigator.navigateUp() },
            { }
        ) },
        modifier = Modifier
            .padding(16.dp)
            .background(Background)
    ) {
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            item {
                card.DrawFullScale()
            }

        }
    }
}