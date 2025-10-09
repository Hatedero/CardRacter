package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.data.card.Card
import com.retardero.cardracter.data.card.CharacterCard
import com.retardero.cardracter.destinations.CardDetailScreenDestination
import com.retardero.cardracter.ui.NavBar
import com.retardero.cardracter.ui.EditTopBar
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.Secondary

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
@Composable
fun NewCardScreen (navigator: DestinationsNavigator, card : Card = CharacterCard.testData()) {
    Scaffold (
        bottomBar = { NavBar(navigator) },
        topBar = { EditTopBar(
            { navigator!!.navigateUp() },
            { }
        ) },
        modifier = Modifier
            .padding(16.dp)
            .background(Background)
    ) {
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            item {
                card.DrawFullScale()
                Row (modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(modifier = Modifier.fillMaxWidth(0.7F)){
                        newCardSaveButton(navigator)
                    }
                    Box(modifier = Modifier.fillMaxWidth()) {
                        newCardUndoButton(navigator)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}

@Composable
fun newCardSaveButton(navigator : DestinationsNavigator){
    Button(
        onClick = {navigator.navigate(CardDetailScreenDestination)},
        modifier = Modifier
            .fillMaxWidth(0.9F)
            .border(shape = RoundedCornerShape(20.dp),width=4.dp, color = Primary)
        ,
        colors = ButtonColors(
            containerColor = Primary ,
            contentColor = Color(red=0, green=0, blue=0),
            disabledContainerColor = Background,
            disabledContentColor = Primary
        )
    ) {
        Text(
            text="Save",
            modifier = Modifier.background(Primary),
        )
    }
}

@Composable
fun newCardUndoButton(navigator : DestinationsNavigator){
    val redColor =  Color(red=186, green=26, blue=26);
    Button(
        onClick = { navigator.navigateUp()},
        modifier = Modifier
            .fillMaxWidth(0.9F)
            .border(shape = RoundedCornerShape(20.dp),width=4.dp, color = redColor)
        ,
        colors = ButtonColors(
            containerColor = Secondary ,
            contentColor = Color(red=0, green=0, blue=0),
            disabledContainerColor = Background,
            disabledContentColor = redColor
        )
    ) {
        Text(
            text="Undo",
        )
    }
}