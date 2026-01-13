package com.retardero.cardracter.account.presentation

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.app.components.TextDisplay
import com.retardero.cardracter.app.components.AccountPicture
import com.retardero.cardracter.app.components.DateDisplay
import com.retardero.cardracter.app.components.DefaultAccountButton
import com.retardero.cardracter.destinations.LoginScreenDestination
import com.retardero.cardracter.destinations.ModifyAccountDestination
import com.retardero.cardracter.homepage.domain.AccountViewModel

@Destination
@Composable
fun ViewAccountBody(
    navigator: DestinationsNavigator,
    viewModel: AccountViewModel = viewModel()
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
            Spacer(modifier = Modifier.height(16.dp))
            TextDisplay("Username",activeAccount.name)
            Spacer(modifier = Modifier.height(16.dp))
            TextDisplay("Email",activeAccount.mail)
            Spacer(modifier = Modifier.height(16.dp))
            Row (modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth(0.5F)){
                    DateDisplay("Date of Birth",activeAccount.dateOfBirth)
                }
                Spacer(modifier = Modifier.width(24.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    DateDisplay("Joined on the",activeAccount.dateJoined)
                }
            }
        }
        Row(modifier = Modifier.heightIn(128.dp,184.dp).fillMaxSize(),
            horizontalArrangement  = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            DefaultAccountButton({navigator.navigate(LoginScreenDestination)},"LOG OUT")
        }
    }
}