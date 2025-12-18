package com.retardero.cardracter.app.model

import androidx.room.PrimaryKey
import java.time.LocalDate

data class Account(
        @PrimaryKey
        val id: Int,
        val name: String,
        val mail: String,
        val dateOfBirth: LocalDate,
        val dateJoined : LocalDate,
        val image: Int
) {
        companion object {
                fun empty(): Account = Account(
                        -1,
                        "default user",
                        "default@user.fr",
                        LocalDate.of(2000,1,1),
                        LocalDate.of(2026,1,1),
                        image = 0
                )
        }
}
