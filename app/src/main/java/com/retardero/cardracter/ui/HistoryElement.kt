package com.retardero.cardracter.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.R
import com.retardero.cardracter.ui.theme.PrimaryBackground

@Preview(showBackground = true)
@Composable
fun HistoryElement(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(1.dp, PrimaryBackground),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Image(
            modifier = Modifier,
            contentDescription = "search Logo",
            painter = painterResource(R.drawable.search_icon)
        )
        Text("Jefrey Jackob", modifier = Modifier.padding(2.dp, 4.dp))
    }
}