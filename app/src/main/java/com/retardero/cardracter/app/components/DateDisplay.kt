package com.retardero.cardracter.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign.Companion.Left
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.PrimaryBackground
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun DateDisplay(label : String, date : LocalDate) {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    Column (
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        verticalArrangement = Arrangement.Center
    ) {
        Text(label,textAlign = Left)
        Text(date.format(formatter), modifier = Modifier
            .background(PrimaryBackground)
            .border(shape = RoundedCornerShape(5.dp),width=1.dp, color = Primary)
            .fillMaxWidth()
            .padding(8.dp),
            textAlign = Left,
            fontSize = 18.sp,
            color = Primary
        )
    }
}