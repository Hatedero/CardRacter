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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.PrimaryBackground
import com.retardero.cardracter.ui.theme.darkBackground

@Composable
fun DefaultAccountButton(action : ()-> Unit, label : String){
    Button(
        onClick = action,
        modifier = Modifier
            .fillMaxWidth(0.7F)
            .border(shape = RoundedCornerShape(20.dp),width=4.dp, color = darkBackground)
        ,
        colors = ButtonColors(
            containerColor = darkBackground ,
            contentColor = Color(red=0, green=0, blue=0),
            disabledContainerColor = Background,
            disabledContentColor = darkBackground
        )
    ) {
        Text(
            text=label,
            color = PrimaryBackground,
            style = TextStyle(
                fontSize = 18.sp
            )
        )
    }
}
