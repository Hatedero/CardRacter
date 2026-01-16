package com.retardero.cardracter.account.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.BuildConfig.FLAVOR_ID
import com.retardero.cardracter.app.components.TextDisplay
import com.retardero.cardracter.app.components.AccountPicture
import com.retardero.cardracter.app.components.DateDisplay
import com.retardero.cardracter.app.components.DefaultAccountButton
import com.retardero.cardracter.app.components.TextField
import com.retardero.cardracter.destinations.LoginScreenDestination
import com.retardero.cardracter.destinations.ModifyAccountDestination
import com.retardero.cardracter.homepage.domain.AccountViewModel
import com.retardero.cardracter.ui.theme.Primary

@Destination
@Composable
fun ViewAccountBody(
    navigator: DestinationsNavigator,
    viewModel: AccountViewModel
) {
    if(viewModel.hasDefaultCard()) {
        viewModel.fetchAccount(1)
    }
    val activeAccount by viewModel.activeUser.collectAsState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.7f)
        ) {
            AccountPicture()
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column (
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DefaultAccountButton({navigator.navigate(ModifyAccountDestination)},"MODIFY PROFILE")
            if (FLAVOR_ID == "debug") {
                Spacer(modifier = Modifier.height(16.dp))
                TextField("User id", "your",{viewModel.fetchAccount(it.length)})
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextDisplay("Username", activeAccount.name)
            Spacer(modifier = Modifier.height(16.dp))
            TextDisplay("Email",activeAccount.mail)
            Spacer(modifier = Modifier.height(16.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.fillMaxWidth(0.5F)){
                    DateDisplay("Date of Birth",activeAccount.dateOfBirth)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    DateDisplay("Joined on the",activeAccount.dateJoined)
                }
            }
        }
        var heightLower: Int = 128
        var heightHigher: Int = 184

        if (FLAVOR_ID == "debug") {
            heightLower = 64
            heightHigher = 86
        }
            Row(modifier = Modifier.heightIn(heightLower.dp,heightHigher.dp).fillMaxSize(),
            horizontalArrangement  = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            DefaultAccountButton({navigator.navigate(LoginScreenDestination)},"LOG OUT")
        }
    }
}