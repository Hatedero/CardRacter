package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.data.card.CharacterCard
import com.retardero.cardracter.ui.CardDisplay
import com.retardero.cardracter.ui.NavBar
import com.retardero.cardracter.ui.ProfileTab
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.R
import com.retardero.cardracter.app.components.destinations.CardDetailScreenDestination
import com.retardero.cardracter.ui.SeachTopBar
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.Secondary

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination(start = true)
@Composable
fun SearchScreen(navigator: DestinationsNavigator) {
    Scaffold (
        bottomBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, RoundedCornerShape(8.dp))
            ) {
                NavBar()} },
        topBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, CircleShape)
            ) {
                SeachTopBar()
            }},
        modifier = Modifier.padding(8.dp)
            .background(Background)
    ) {
        SearchHistory()
    }
}

@Composable
fun SearchHistory(){
    val background : Color = Color(255,216,230)
    Box(modifier = Modifier
        .background(background)
        .fillMaxWidth()
        .border(
            border = BorderStroke(1.dp, Primary),
            shape = RoundedCornerShape(10.dp)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text("History", modifier = Modifier.padding(top = 8.dp, bottom = 12.dp), fontSize = 20.sp)
            for (i in 1..10) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(1.dp, background),
                        shape = RoundedCornerShape(10.dp)
                    )
                ) {
                    Image(
                        modifier = Modifier,
                        contentDescription="search Logo", painter= painterResource(R.drawable.search_icon))
                    Text("Jefrey Jackob", modifier = Modifier.padding(2.dp, 4.dp))
                }
            }
        }
    }
}