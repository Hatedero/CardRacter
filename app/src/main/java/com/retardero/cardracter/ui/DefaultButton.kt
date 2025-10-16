package com.retardero.cardracter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.destinations.CardDetailScreenDestination
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary

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