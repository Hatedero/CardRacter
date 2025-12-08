package com.retardero.cardracter.account.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary

@Destination
@Composable
fun AccountScreen(
    navigator: DestinationsNavigator,
) {
    Scaffold(
        topBar = {
            IconButton(
                {navigator.navigateUp()},
            ) {
                Icon(imageVector = Icons.Filled.Close,
                    contentDescription = "Favorite",
                    modifier = Modifier.fillMaxSize(),
                    tint = Primary
                )
            }
        },
        modifier = Modifier
            .padding(16.dp)
            .background(Background)
            .fillMaxSize()
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
        ) {
            item {
                ViewAccountBody(navigator)
            }
        }
    }
}