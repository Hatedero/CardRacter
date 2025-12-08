package com.retardero.cardracter

import android.app.Application
import com.retardero.cardracter.app.database.DBDataSource

class CardRacterApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DBDataSource.init(applicationContext)
    }
}