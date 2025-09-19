package com.retardero.cardracter.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.R
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.PrimaryBackground

@Preview(showBackground = true)
@Composable
fun Tag(){
    Row(modifier = Modifier
        .border(
            border = BorderStroke(1.dp, PrimaryBackground),
            shape = RoundedCornerShape(10.dp)
        )
        .background(
            color= Primary,
            shape =RoundedCornerShape(10.dp)
        )
        .padding(vertical = 4.dp)
    ) {
        Image(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            contentDescription="search Logo", painter= painterResource(R.drawable.trending_icon))
        Text("Jefrey Jackob",
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp))
    }
}