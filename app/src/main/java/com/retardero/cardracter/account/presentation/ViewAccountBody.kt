package com.retardero.cardracter.account.presentation

import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.app.components.TextDisplay
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.app.components.AccountPicture
import com.retardero.cardracter.app.components.DateDisplay
import com.retardero.cardracter.app.components.DefaultAccountButton
import com.retardero.cardracter.destinations.LoginScreenDestination
import com.retardero.cardracter.destinations.ModifyAccountDestination
import java.time.LocalDate

@Destination
@Composable
fun ViewAccountBody(navigator: DestinationsNavigator) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.7f)
        ) {
            AccountPicture()
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DefaultAccountButton({navigator.navigate(ModifyAccountDestination)},"MODIFY PROFILE")
            Spacer(modifier = Modifier.height(10.dp))
            TextDisplay("Username","YourUsername")
            Spacer(modifier = Modifier.height(10.dp))
            TextDisplay("Email","your@email.com")
            Spacer(modifier = Modifier.height(10.dp))
            TextDisplay("Password","••••••")
            Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth(0.5F)){
                    DateDisplay("Date of Birth",LocalDate.of(2002, 12, 25))
                }
                Spacer(modifier = Modifier.width(20.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    DateDisplay("Joined on the",LocalDate.of(2023, 8, 14))
                }
            }
            Spacer(modifier = Modifier.height(64.dp))
            Column(modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                DefaultAccountButton({navigator.navigate(LoginScreenDestination)},"LOG OUT")
            }
        }
    }
}