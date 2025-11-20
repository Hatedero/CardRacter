package com.retardero.cardracter.account.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.app.components.AccountPicture
import com.retardero.cardracter.app.components.DateField
import com.retardero.cardracter.app.components.TextField
import com.retardero.cardracter.app.components.UndoButton
import com.retardero.cardracter.destinations.SignupScreenDestination
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary
import java.time.LocalDate

@Destination
@Composable
fun ModifyAccount(navigator: DestinationsNavigator) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AccountPicture(tranparency = 0.5f)
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            TextField("Username","YourUsername")
            Spacer(modifier = Modifier.height(10.dp))
            TextField("Email","your@email.com")
            Spacer(modifier = Modifier.height(10.dp))
            TextField("Password","••••••")
            Spacer(modifier = Modifier.height(10.dp))
            DateField(
                "Date of Birth", LocalDate.of(2002, 8, 14),{}
            )
            Column(modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Row (modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(modifier = Modifier.fillMaxWidth(0.7F)){
                        SaveButton(navigator)
                    }
                    Box(modifier = Modifier.fillMaxWidth()) {
                        UndoButton(navigator)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Spacer(modifier = Modifier.height(40.dp))
                DeleteAccount(navigator)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun DeleteAccount(navigator: DestinationsNavigator){
    Text(
        modifier = Modifier.clickable{navigator.navigate(SignupScreenDestination)},
        text = "delete account",
        color = Color(255,0,0),
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun SaveButton(navigator: DestinationsNavigator){
    Button(
        onClick = { navigator.navigateUp()},
        modifier = Modifier
            .fillMaxWidth(0.9F)
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
            text="Save",
            modifier = Modifier.background(Primary),
        )
    }
}