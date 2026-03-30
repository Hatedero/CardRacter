package com.retardero.cardracter.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.R
import com.retardero.cardracter.ui.theme.Primary

@Composable
fun HistoryElement(history_element : String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier,
            contentDescription = "search Logo",
            painter = painterResource(R.drawable.search_icon)
        )
        Text(
            history_element,
            modifier = Modifier.padding(horizontal = 8.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = Bold,
            color = Primary
        )
    }
}