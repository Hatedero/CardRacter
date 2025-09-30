package com.retardero.cardracter.app

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.app.components.NavBar
import com.retardero.cardracter.app.components.SeachTopBar
import com.retardero.cardracter.app.components.SearchHistory
import com.retardero.cardracter.app.components.TagHistory

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
@Composable
fun SearchScreen(navigator: DestinationsNavigator) {
    Scaffold (
        bottomBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, RoundedCornerShape(8.dp))
            ) {
                NavBar(navigator)
            } },
        topBar = {
            Row (
                modifier = Modifier.padding(0.dp)
                    .shadow(8.dp, RoundedCornerShape(10.dp))
            ) {
                SeachTopBar()
            }},
        modifier = Modifier.padding(8.dp)

    ) {
        Column (
            modifier = Modifier
                .padding(top = 64.dp, bottom = 64.dp, )
                .fillMaxSize()
        ) {
            SearchHistory()
            Spacer(modifier = Modifier.height(10.dp))
            TagHistory()
        }
    }
}