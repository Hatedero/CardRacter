package com.retardero.cardracter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign.Companion.Left
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.PrimaryBackground


@Composable
fun TextDisplay(label : String, display : String) {
    Column (
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        verticalArrangement = Arrangement.Center
    ) {
        Text(label,textAlign = Left)
        Text(display, modifier = Modifier
            .background(PrimaryBackground)
            .border(shape = RoundedCornerShape(5.dp),width=1.dp, color = Primary)
            .fillMaxWidth()
            .padding(8.dp),
            textAlign = Left,
            fontSize = 20.sp,
            color = Primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDisplay(){
    TextDisplay("Lable","Text")
}