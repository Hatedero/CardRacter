package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.retardero.cardracter.data.card.Card
import com.retardero.cardracter.data.card.CharacterCard
import com.retardero.cardracter.ui.NavBar
import com.retardero.cardracter.ui.EditTopBar
import com.retardero.cardracter.ui.theme.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination(start = true)
@Preview(showBackground = true)
@Composable
fun CardDetailScreen (card : Card = CharacterCard.testData()) {
    Scaffold (
        bottomBar = { NavBar() },
        topBar = { EditTopBar() },
        modifier = Modifier.padding(16.dp)
            .background(Background)
    ) {
        LazyColumn (
            modifier = Modifier.fillMaxSize()
                .padding(it)
        ) {
            item {
                card.Draw()
            }
        }
    }
}