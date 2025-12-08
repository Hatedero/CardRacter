package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.ui.theme.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
@Composable
fun SearchScreen(navigator: DestinationsNavigator) {
    Scaffold (
        modifier = Modifier.padding(8.dp)
            .background(Background),
        bottomBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, RoundedCornerShape(20.dp))
            ) {
                NavBar(navigator)}
        },
        topBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .background(Background) .shadow(8.dp, RoundedCornerShape(10.dp))

            ) {
                SeachTopBar()
            }
         },
    ) {
        Column (
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SearchHistory()
            Spacer(modifier = Modifier.height(8.dp))
            TagHistory()
        }
    }
}