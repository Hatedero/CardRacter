package com.retardero.cardracter.app.components

import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Label
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.ui.theme.CardRacterTheme

@Destination(start = true)
@Composable
fun SignupScreen(navigator: DestinationsNavigator?) {

    Column (
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Row (
            modifier = Modifier.background(Color.Yellow)
                .fillMaxWidth()
                .height(200.dp)
        ) {  }

        Column (
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            field("Email/Username")
            Spacer(modifier = Modifier.height(10.dp))
            field("Password")
            Spacer(modifier = Modifier.height(10.dp))
            field("Confirm Password")
        }
        Text("Forgot your password ?", color = Color.Blue, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), textDecoration = TextDecoration.Underline)
        Spacer(modifier = Modifier.height(40.dp))
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Sign up with")
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.clip(CircleShape)
                        .background(Color.Cyan)
                        .width(80.dp)
                        .height(80.dp)
                ) {

                }
                Box(
                    modifier = Modifier.clip(CircleShape)
                        .background(Color.Cyan)
                        .width(80.dp)
                        .height(80.dp)
                ) {

                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = { }
            ) { Text("SIGN UP") }
            Spacer(modifier = Modifier.height(20.dp))
            Text("Already have an account?", color = Color.Blue, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignupPreview() {
    CardRacterTheme {
        SignupScreen(null)
    }
}