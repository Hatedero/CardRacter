package com.retardero.cardracter.app.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DefaultButton(action : () -> Unit, text : String, background : Color, textColor: Color){
    Button(
        onClick = action,
        modifier = Modifier
            .fillMaxWidth(0.9F)
        ,
        colors = ButtonDefaults.buttonColors(containerColor =  background)
    ) {
        Text(
            text=text,
            color = textColor
        )
    }
}