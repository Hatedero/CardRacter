package com.retardero.cardracter.app.components

import androidx.compose.foundation.background
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
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary

@Composable
fun DefaultAccountButton(action : ()-> Unit, label : String){
    Button(
        onClick = action,
        modifier = Modifier
            .fillMaxWidth(0.7F)
            .border(shape = RoundedCornerShape(20.dp),width=4.dp, color = Primary)
        ,
        colors = ButtonColors(
            containerColor = Primary ,
            contentColor = Color(red=0, green=0, blue=0),
            disabledContainerColor = Background,
            disabledContentColor = Primary
        )
    ) {
        Text(
            text=label,
            modifier = Modifier.background(Primary),
        )
    }
}
