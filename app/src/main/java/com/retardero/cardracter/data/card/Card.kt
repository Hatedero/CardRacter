package com.retardero.cardracter.data.card

import androidx.compose.runtime.Composable
import com.retardero.cardracter.data.category.base.CardCategory

abstract class Card (
    var attributes: CardCategory
) {

    @Composable
    abstract fun DrawFullScale() : Unit

    @Composable
    abstract fun DrawSimplified() : Unit
}