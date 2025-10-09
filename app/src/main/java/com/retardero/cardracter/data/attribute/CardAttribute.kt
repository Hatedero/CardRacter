package com.retardero.cardracter.data.attribute

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.retardero.cardracter.data.card.Card
import com.retardero.cardracter.data.card.Card.MultiCategoryCard.CharacterCard
import com.retardero.cardracter.ui.SimplifiedMCDVisual

class CardAttribute(
    title: String?,
    card: Card.MultiCategoryCard = CharacterCard.testData()
) : CustomAttribute(title) {
    var card: Card.MultiCategoryCard = card

    companion object {
        fun testData(): CardAttribute = CardAttribute(
            "Artorias",
            CharacterCard.testData()
        )
    }

    @Composable
    override fun draw() {
        return SimplifiedMCDVisual(card)
    }
}