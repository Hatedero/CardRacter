package com.retardero.cardracter.app.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.ui.theme.Background

@Composable
fun UndoButton(navigator: DestinationsNavigator){
    val redColor =  Color(red=186, green=26, blue=26);
    Button(
        onClick = { navigator.navigateUp()},
        modifier = Modifier
            .fillMaxWidth(0.9F)
            .border(shape = RoundedCornerShape(20.dp),width=4.dp, color = redColor)
        ,
        colors = ButtonColors(
            containerColor = redColor,
            contentColor = Color.Black,
            disabledContainerColor = Background,
            disabledContentColor = redColor
        )
    ) {
        Text(
            text="Undo",
        )
    }
}