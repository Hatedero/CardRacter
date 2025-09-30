package com.retardero.cardracter.app.model.attribute

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.retardero.cardracter.data.card.Card
import com.retardero.cardracter.app.model.card.CharacterCard

class CardAttribute(
    title: String?,
    card: Card = com.retardero.cardracter.app.model.card.CharacterCard.testData()
) : CustomAttribute(title) {
    var card: Card = card

    companion object {
        fun testData(): CardAttribute = CardAttribute(
            "Artorias",
            com.retardero.cardracter.app.model.card.CharacterCard.testData()
        )
    }

    @Composable
    override fun draw() {
        return card.DrawSimplified()
    }
}