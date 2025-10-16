package com.retardero.cardracter.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable

@Composable
fun FloatingActionMenuEditCard(save : () -> Unit, undo : () -> Unit) {
    FloatingActionMenu(
        closedIcon = Icons.Default.Edit,
        options = mapOf(Pair(Icons.Default.Check, save),
            Pair(Icons.Default.Refresh, undo))
    )
}