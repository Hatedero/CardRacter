package com.retardero.cardracter.app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Label
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.ui.BaseButton
import com.retardero.cardracter.ui.theme.CardRacterTheme

@Destination
@Composable
fun LoginScreen(navigator: DestinationsNavigator?) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Column (

        ) {

            TextField(
                "email@email.com",
                onValueChange = {}
            )
        }
        Column (

        ) {
            BaseButton("Login", "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CardRacterTheme {
        LoginScreen(null)
    }
}