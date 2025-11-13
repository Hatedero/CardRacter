package com.retardero.cardracter.collections.model


//data class Cards(@Serialized("cards") val cardList: List<Card>)
data class ModifiableCards(var cardList: List<ModifiableCard>)