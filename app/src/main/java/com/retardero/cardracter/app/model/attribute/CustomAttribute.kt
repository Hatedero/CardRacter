package com.retardero.cardracter.app.model.attribute

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

abstract class CustomAttribute (
    var title: String?
) {

    @Composable
    abstract fun draw()


}