package com.retardero.cardracter.data.attribute

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

abstract class CustomAttribute (
    var title: String?
) {

    @Composable
    abstract fun draw()


}