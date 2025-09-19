package com.retardero.cardracter.data.category

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.navargs.NavTypeSerializer
import com.retardero.cardracter.data.attribute.CustomAttribute
import com.retardero.cardracter.ui.theme.Primary

abstract class CustomCategory (
    var attributes: List<CustomAttribute> = emptyList(),
    var title: String = "Empty Category"
) {

    @Composable
    abstract fun draw()
}