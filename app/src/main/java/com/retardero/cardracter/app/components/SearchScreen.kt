package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.ui.NavBar
import com.retardero.cardracter.ui.HistoryElement
import com.retardero.cardracter.ui.SeachTopBar
import com.retardero.cardracter.ui.SearchHistory
import com.retardero.cardracter.ui.Tag
import com.retardero.cardracter.ui.TagHistory
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.PrimaryBackground

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
@Preview(showBackground = true)
@Composable
fun SearchScreen(navigator: DestinationsNavigator? = null) {
    Scaffold (
        bottomBar = {
            Row (
                modifier = Modifier.padding(0.dp)
                    .shadow(8.dp, RoundedCornerShape(8.dp))
            ) {
                NavBar()} },
        topBar = {
            Row (
                modifier = Modifier.padding(0.dp)
                    .shadow(8.dp, CircleShape)
            ) {
                SeachTopBar()
            }},
        modifier = Modifier.padding(16.dp)

    ) {
        Column (
            modifier = Modifier
                .padding(top = 64.dp, bottom = 64.dp)
                .fillMaxSize()
        ) {
            SearchHistory()
            Spacer(modifier = Modifier.height(10.dp))
            TagHistory()
        }
    }
}