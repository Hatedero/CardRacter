package com.retardero.cardracter.app

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.app.components.NavBar
import com.retardero.cardracter.app.components.ProfileTab
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.data.card.CollectionCard
import com.retardero.cardracter.destinations.CardDetailScreenDestination
import com.retardero.cardracter.app.components.CollectionDisplay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
//@Preview(showBackground = true)
@Composable
fun CollectionsScreen(navigator: DestinationsNavigator) {
    Scaffold (
        bottomBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, RoundedCornerShape(20.dp))
            ) {
            NavBar(navigator)
            } },
        topBar = {
            Row (
                modifier = Modifier.padding(8.dp)
                    .shadow(8.dp, CircleShape)
            ) {
                ProfileTab()
            }},
        modifier = Modifier.padding(8.dp)
            .background(Background)
    ) {
            LazyColumn (
            ) {
                    item {
                         CollectionDisplay(CollectionCard.testData(), {
                            navigator.navigate(CardDetailScreenDestination())
                        })
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                item {
                    CollectionDisplay(CollectionCard.testData(), {
                        navigator.navigate(CardDetailScreenDestination())
                    })
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
}

