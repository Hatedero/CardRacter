package com.retardero.cardracter.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.ui.TextDisplay
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.Secondary

@Destination(start = true)
@Preview(showBackground = true)
@Composable
fun AccountScreen(navigator: DestinationsNavigator? = null) {
    Column (
        modifier = Modifier.fillMaxSize()
            .background(Background)
    ) {
        Row (
            modifier = Modifier.background(Primary)
                .fillMaxWidth()
                .height(200.dp)
        ) {
        }

        Column (
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .border(shape = RoundedCornerShape(20.dp),width=4.dp, color = Primary)
                ,
                colors = ButtonColors(
                    containerColor = Primary ,
                    contentColor = Color(red=0, green=0, blue=0),
                    disabledContainerColor = Background,
                    disabledContentColor = Primary
                )
            ) {
            Text(
                text="MODIFY PROFILE",
                modifier = Modifier.background(Primary),
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            TextDisplay("Username","YourUsername")
            Spacer(modifier = Modifier.height(10.dp))
            TextDisplay("Email","your@email.com")
            Spacer(modifier = Modifier.height(10.dp))
            TextDisplay("Password","••••••")
            Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth(0.5F)){
                    TextDisplay("Date of Birth","25/12/2002")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    TextDisplay("Join on the", "14/08/2023")
                }
            }

        }
        Box(
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .border(shape = RoundedCornerShape(20.dp), width = 4.dp, color = Primary),
                colors = ButtonColors(
                    containerColor = Primary,
                    contentColor = Color(red = 0, green = 0, blue = 0),
                    disabledContainerColor = Background,
                    disabledContentColor = Primary
                )
            ) {
                Text(
                    text = "LOG OUT",
                    modifier = Modifier.background(Primary),
                )
            }
        }
    }
}