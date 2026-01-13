package com.retardero.cardracter.app.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp

@Composable
fun AccountTextField(lable : String, fieldValue : String = "", onValueChange: (String) -> Unit = {}) {
    var field by remember { mutableStateOf(fieldValue) }
    Log.d("user",lable+" "+fieldValue)
    Column (
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(lable)

        TextField(
            value = fieldValue,
            onValueChange = {
                field = it
                onValueChange(it)
            },
            modifier = Modifier.clip(RoundedCornerShape(100))
        )
    }
}