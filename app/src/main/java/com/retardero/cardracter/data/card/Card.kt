package com.retardero.cardracter.data.card

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.navargs.NavTypeSerializer
import com.retardero.cardracter.R
import com.retardero.cardracter.data.category.CustomCategory
import com.retardero.cardracter.data.category.base.CardCategory

abstract class Card (
    var attributes: CardCategory
) {

    @Composable
    abstract fun Draw() : Unit
}