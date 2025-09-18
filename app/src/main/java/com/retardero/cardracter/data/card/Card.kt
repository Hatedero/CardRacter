package com.retardero.cardracter.data.card

import androidx.compose.runtime.Composable
import com.retardero.cardracter.R
import com.retardero.cardracter.data.category.CustomCategory

abstract class Card (
    var title: String?,
    var description: String?,
    var illustration: Int? = R.drawable.default_pp,
    var categories: List<CustomCategory>? = emptyList()
) {

    @Composable
    abstract fun Draw() : Unit
}