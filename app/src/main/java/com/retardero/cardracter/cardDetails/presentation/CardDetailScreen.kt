package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Index
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.homepage.domain.CardDetailViewModel
import com.retardero.cardracter.homepage.domain.IndexViewModel
import com.retardero.cardracter.ui.theme.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
@Composable
fun CardDetailScreen(
    navigator: DestinationsNavigator,
    viewModel: CardDetailViewModel = viewModel(),
    cardId : Int
) {
    val activeCard by viewModel.characterCard.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCard(cardId)
    }

    Scaffold(
        bottomBar = { NavBar(navigator) },
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            item {
                FullScaleCardVisual(activeCard)
            }

        }
    }
}