package com.retardero.cardracter.app.components

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.R
import com.retardero.cardracter.destinations.IndexScreenDestination
import com.retardero.cardracter.destinations.LoginScreenDestination
import com.retardero.cardracter.homepage.domain.LoginSignUpViewModel
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.Secondary


@Destination
@Composable
fun SignupScreen(
    navigator: DestinationsNavigator,
    viewModel: LoginSignUpViewModel = viewModel()
) {
    val activeAccount by viewModel.activeUser.collectAsState()

    Column (
        modifier = Modifier.fillMaxSize()
            .background(Background)
            .verticalScroll(rememberScrollState())
    ) {
        Row (
            modifier = Modifier.background(Primary)
                .fillMaxWidth()
                .height(200.dp)
        ) {  }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            TextField("Username", "",{viewModel.updateName(it)})
            Spacer(modifier = Modifier.height(10.dp))
            TextField("Email", "",  {viewModel.updateEmail(it)})
            Spacer(modifier = Modifier.height(10.dp))
            TextField("Password")
            Spacer(modifier = Modifier.height(10.dp))
            TextField("Confirm Password")
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.5F)
                    .fillMaxWidth(0.8F)
                    .background(Background)
                    .padding(16.dp),
            )
            {
                DateField(
                    "Date of Birth", activeAccount.dateOfBirth, { viewModel.updateDateOfBirth(it) }
                )
            }
        }
        Text("Forgot your password ?", color = Color.Blue, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), textDecoration = TextDecoration.Underline)
        Spacer(modifier = Modifier.height(30.dp))
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
                ActionLogo(R.drawable.google_logo,{navigator.navigate(IndexScreenDestination)},"sign up with Google button")
                ActionLogo(R.drawable.tiktok_logo,{navigator.navigate(IndexScreenDestination)},"sign up with Tiktok button")
                ActionLogo(R.drawable.facebook_logo,{navigator.navigate(IndexScreenDestination)},"sign up with Facebook button")
            }
            Spacer(modifier = Modifier.height(40.dp))
            signUpButton(navigator,viewModel)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Already have an account?",
                color = Color.Blue,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable{navigator.navigate(LoginScreenDestination)}
                ,
                textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun signUpButton(navigator: DestinationsNavigator, viewModel: LoginSignUpViewModel) {
    val isFormValid by viewModel.isFormValid.collectAsState()
    Button(
        modifier = Modifier.fillMaxWidth(0.6f).fillMaxHeight(0.25f),
        onClick = {
            viewModel.signUpUser{ navigator.navigate(LoginScreenDestination) }
        },
        colors = ButtonColors(
            containerColor = if (isFormValid) Secondary else Color.Red,
            contentColor = Color.Black,
            disabledContainerColor = Background,
            disabledContentColor = Secondary
        )
    ) {
        Text(
            "SIGN UP",
            style = TextStyle(
                fontSize = 28.sp
            ),
            color = Primary
        )
    }
}