package com.retardero.cardracter.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.ui.TextField
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.CardRacterTheme
import com.retardero.cardracter.ui.theme.Primary

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
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            TextField("Email/Username")
            Spacer(modifier = Modifier.height(10.dp))
            TextField("Password")
        }
        Text("Forgot your password ?", color = Color.Blue, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), textDecoration = TextDecoration.Underline)
        Spacer(modifier = Modifier.height(80.dp))
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Login with")
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.clip(CircleShape)
                        .background(Primary)
                        .width(80.dp)
                        .height(80.dp)
                ) {

                }
                Box(
                    modifier = Modifier.clip(CircleShape)
                        .background(Primary)
                        .width(80.dp)
                        .height(80.dp)
                ) {

                }
            }
            Spacer(modifier = Modifier.height(60.dp))
            Button(
                onClick = { }
            ) { Text("LOGIN") }
            Spacer(modifier = Modifier.height(20.dp))
            Text("Don't have an account ?", color = Color.Blue, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), textDecoration = TextDecoration.Underline)
        }
    }
}