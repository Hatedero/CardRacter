package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.retardero.cardracter.R
import com.retardero.cardracter.data.Card
import com.retardero.cardracter.data.CharacterCard
import com.retardero.cardracter.ui.CardDisplay
import com.retardero.cardracter.ui.NavBar
import com.retardero.cardracter.ui.ProfileTab
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary
import com.retardero.cardracter.ui.theme.PrimaryContainer

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
@Preview(showBackground = true)
@Composable
fun CardDetailScreen (card : Card = CharacterCard.empty()) {
    Scaffold (
        bottomBar = { NavBar() },
        topBar = { Row (
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(0.05f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "icon",
                    tint = Primary,
                    modifier = Modifier.fillMaxHeight()
                        .aspectRatio(1f)
                )

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "icon",
                    tint = Primary,
                    modifier = Modifier.fillMaxHeight()
                        .aspectRatio(1f)
                )
        } },
        modifier = Modifier.padding(16.dp)
            .background(Background)
    ) {
        LazyColumn (
            modifier = Modifier.fillMaxSize()
                .padding(it)
        ) {
            item {
                card.Draw()
            }
        }
    }
}