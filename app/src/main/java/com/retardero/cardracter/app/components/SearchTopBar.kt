package com.retardero.cardracter.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.PrimaryBackground
import com.retardero.cardracter.ui.theme.veryLightGrey

@Preview(showBackground = true)
@Composable
fun SeachTopBar() {
    Row (
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(0.07f)
            .clip(RoundedCornerShape(16.dp))
            .background(veryLightGrey),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var search by remember { mutableStateOf("knightly knight") }

        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "icon",
                tint = Primary,
                modifier = Modifier
                    .fillMaxHeight(0.6f)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { }
            )
        }

        TextField(
            search,
            {
                search = it
            },
            Modifier.fillMaxHeight()
                .fillMaxWidth(0.8f),
            colors = TextFieldDefaults.colors(focusedContainerColor = Color.Transparent, unfocusedContainerColor = Color.Transparent, unfocusedTextColor = Color.Black),
            textStyle = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = Bold,
            ),
        )

        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "icon",
                tint = Primary,
                modifier = Modifier
                    .fillMaxHeight(0.6f)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { }
            )
        }
    }
}