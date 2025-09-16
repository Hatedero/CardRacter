package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.retardero.cardracter.ui.CardDisplay
import com.retardero.cardracter.ui.NavBar
import com.retardero.cardracter.ui.ProfileTab
import com.retardero.cardracter.ui.theme.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination(start = true)
@Preview(showBackground = true)
@Composable
fun IndexScreen() {
    Scaffold (
        bottomBar = { NavBar() },
        topBar = { ProfileTab() },
        modifier = Modifier.padding(16.dp)
            .background(Background)
    ) {
        var content = listOf("Gwyn, Lord of Cinder", "Solaire of Astora", "Artorias the Abysswalker", "Manus, Father of the Abyss", "Seath the Scaleless")
        Row (

        ) {
            Column (
                modifier = Modifier.fillMaxWidth(0.55f)
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                content.forEach { card ->
                    CardDisplay(card)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            Column (
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                content.asReversed().forEach { card ->
                    CardDisplay(card)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}