package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.destinations.CardDetailScreenDestination
import com.retardero.cardracter.destinations.NewCardScreenDestination
import com.retardero.cardracter.homepage.domain.CollectionsViewModel
import com.retardero.cardracter.homepage.domain.ModifyCardViewModel
import com.retardero.cardracter.ui.ProfileTab
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.veryLightGrey

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
//@Preview(showBackground = true)
@Composable
fun CollectionsScreen(
    navigator: DestinationsNavigator,
    viewModel: CollectionsViewModel = viewModel()
) {

    val collections by viewModel.collections.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCollections()
    }

    Scaffold(
        modifier = Modifier
            .padding(8.dp)
            .background(Background),
        floatingActionButton = { AddButton(navigator) },
        bottomBar = {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .shadow(8.dp, RoundedCornerShape(20.dp))
            ) {
                NavBar(navigator,2)
            }
        },
        topBar = {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .shadow(8.dp, CircleShape)
            ){
                ProfileTab(navigator)
            }
        }
    ) {
        LazyColumn(
        ) {
            collections.forEach { collection ->
                item {
                    CollectionDisplay(collection, navigate = {
                    })
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun AddButton(navigator: DestinationsNavigator) {
    /*FloatingActionButton(
        onClick = { navigator.navigate(NewCardScreenDestination) },
        modifier = Modifier.padding(8.dp),
        containerColor = veryLightGrey,
        content = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "icon",
                tint = Primary
            )
        }
    )*/
    FloatingActionMenu(
        Icons.Default.Add,
        mapOf(Pair(Icons.Default.Person, {navigator.navigate(NewCardScreenDestination(-1, 0))}),
            Pair(Icons.Default.List, {navigator.navigate(NewCardScreenDestination(-1, 1))}))
    )
}