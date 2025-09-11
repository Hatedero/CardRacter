package com.retardero.cardracter.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BaseButton(
    text : String,
    action : String
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { action }
    ) {  }
}