package com.retardero.cardracter.app.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.destinations.ModifyAccountScreenDestination
import com.retardero.cardracter.destinations.SignupScreenDestination
import com.retardero.cardracter.ui.AccountButton
import com.retardero.cardracter.ui.TextDisplay
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.AccountPicture


@Destination
@Composable
fun AccountScreen(navigator: DestinationsNavigator ) {
    Column (
        modifier = Modifier.fillMaxSize()
            .background(Background)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AccountPicture()
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AccountButton("MODIFY PROFILE",navigator, ModifyAccountScreenDestination)
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
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                AccountButton("LOG OUT",navigator, SignupScreenDestination)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}