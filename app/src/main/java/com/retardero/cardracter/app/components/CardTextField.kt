package com.retardero.cardracter.app.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary

@Composable
fun CardTitleTextField(value: String, onValueChange: (String) -> Unit) {
    androidx.compose.material3.TextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            color = Primary
        ),
        colors = TextFieldDefaults.colors(unfocusedContainerColor = Background),
        modifier = Modifier.clip(RoundedCornerShape(10.dp))
    )
}

@Composable
fun CardSubTitleTextField(value: String, onValueChange: (String) -> Unit) {
    androidx.compose.material3.TextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Left,
            color = Primary
        ),
        colors = TextFieldDefaults.colors(unfocusedContainerColor = Background),
        modifier = Modifier.clip(RoundedCornerShape(10.dp))
    )
}

@Composable
fun CardTextField(value: String, onValueChange: (String) -> Unit) {
    androidx.compose.material3.TextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            color = Primary
        ),
        colors = TextFieldDefaults.colors(unfocusedContainerColor = Background),
        modifier = Modifier.clip(RoundedCornerShape(10.dp))
    )
}