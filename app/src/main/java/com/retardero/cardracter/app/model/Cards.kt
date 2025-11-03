package com.retardero.cardracter.app.model

import com.google.gson.annotations.SerializedName

data class Cards(@SerializedName("cards") val cardList: List<Card>)