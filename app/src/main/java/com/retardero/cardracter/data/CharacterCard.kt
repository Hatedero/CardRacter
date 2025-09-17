package com.retardero.cardracter.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardero.cardracter.R

class CharacterCard(
    title: String,
    description: String,
    illustration: Int = R.drawable.default_pp
) : Card(title, description, illustration = illustration) {

    @Composable
    override fun Draw() {
        return Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(illustration!!),
                    contentDescription = "icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxHeight()
                )
            }
            Column(
                Modifier.fillMaxSize(),
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(title!!, fontWeight = FontWeight.Bold, fontSize = 40.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(description!!, fontSize = 15.sp)
                }

            }
        }
    }


    companion object {
        fun empty(): CharacterCard = CharacterCard(
            "Empty Card", "Lorem ipsum dolores ignut ignam thaum."
        )
    }

}