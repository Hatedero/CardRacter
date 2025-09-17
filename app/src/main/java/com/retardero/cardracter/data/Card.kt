package com.retardero.cardracter.data

import androidx.compose.runtime.Composable
import com.retardero.cardracter.R

abstract class Card (
    var title: String?,
    var description: String?,
    var categories: List<CustomCategory>? = null,
    var illustration: Int? = R.drawable.default_pp
) {

    @Composable
    abstract fun Draw() : Unit
}