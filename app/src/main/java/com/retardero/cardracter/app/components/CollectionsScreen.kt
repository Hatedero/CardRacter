package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.data.card.Card
import com.retardero.cardracter.ui.NavBar
import com.retardero.cardracter.ui.ProfileTab
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.data.card.Card.CollectionCard
import com.retardero.cardracter.destinations.CardDetailScreenDestination
import com.retardero.cardracter.destinations.NewCardScreenDestination
import com.retardero.cardracter.ui.CollectionDisplay
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.PrimaryContainer
import com.retardero.cardracter.ui.theme.Secondary

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
//@Preview(showBackground = true)
@Composable
fun CollectionsScreen(navigator: DestinationsNavigator) {
    Scaffold (
        floatingActionButton = { AddButton(navigator) },
        bottomBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, RoundedCornerShape(20.dp))
            ) {
                NavBar(navigator)} },
        topBar = {
            Row (
                modifier = Modifier
                    .padding(8.dp)
                    .shadow(8.dp, CircleShape)
            ) {
                ProfileTab(navigator)
            }},
        modifier = Modifier
            .padding(8.dp)
            .background(Background)
    ) {
            LazyColumn (
            ) {
                    item {
                         CollectionDisplay(CollectionCard.testData(), navigate = {
                            navigator.navigate(CardDetailScreenDestination())
                        })
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                item {
                    CollectionDisplay(CollectionCard.testData(), navigate ={
                        navigator.navigate(CardDetailScreenDestination())
                    })
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
}

@Composable
fun AddButton(navigator: DestinationsNavigator){
    FloatingActionButton(
        onClick = { navigator.navigate(NewCardScreenDestination) },
        modifier = Modifier
            .padding(8.dp),
        containerColor = Color.LightGray,
        content = {
            Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "icon",
            tint = Primary)
        }
    )
}