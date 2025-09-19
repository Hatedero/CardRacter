package com.retardero.cardracter.data.attribute

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.R

class ImageAttribute(
    title: String?,
    value: Int? = R.drawable.default_pp
    ) : CustomAttribute(title) {

    var value: Int? = value

    @Composable
    override fun draw(){
        return Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(value!!),
                contentDescription = "icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxHeight()
            )
        }
    }

    companion object{
        fun testData(): ImageAttribute= ImageAttribute(
            title = "My super cosplay",
            value = R.drawable.dix_yeux
        )
        fun testData2(): ImageAttribute= ImageAttribute(
            title = "My super cosplay",
            value = R.drawable.smough
        )
    }

}