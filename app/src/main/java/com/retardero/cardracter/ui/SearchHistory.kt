package com.retardero.cardracter.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.PrimaryBackground

@Composable
fun SearchHistory(){
    Column(
        modifier = Modifier
            .background(PrimaryBackground)
            .fillMaxWidth()
            .border(
                border = BorderStroke(1.dp, Primary),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 8.dp, horizontal = 8.dp)
    ) {
        Text("History", modifier = Modifier
            .padding(8.dp), fontSize = 20.sp)

        LazyColumn(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .height(285.dp)
        ) {
            for (i in 1..20) {
                item {
                    HistoryElement()
                }
            }
        }
    }
}