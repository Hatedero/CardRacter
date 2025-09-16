package com.retardero.cardracter.app.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.ramcosta.composedestinations.annotation.Destination
import com.retardero.cardracter.ui.NavBar
import com.retardero.cardracter.ui.theme.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination(start = true)
@Composable
fun IndexScreen() {
    Scaffold (
        bottomBar = { NavBar() },
        containerColor = Background
    ) {
        Column {  }
    }
}