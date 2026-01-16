package com.retardero.cardracter.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.retardero.cardracter.app.database.dao.attributeDAO
import com.retardero.cardracter.app.database.dao.cardDAO
import com.retardero.cardracter.app.database.dao.categoryDAO
import com.retardero.cardracter.app.database.dao.userDAO
import com.retardero.cardracter.app.database.intermediary.IntermediaryAttribute
import com.retardero.cardracter.app.database.intermediary.IntermediaryCard
import com.retardero.cardracter.app.database.intermediary.IntermediaryCategory
import com.retardero.cardracter.app.model.User

object DBDataSource {
    private var instance: AppDatabase? = null

    fun init(context: Context): AppDatabase {
        instance =
            Room.databaseBuilder(context,
                AppDatabase::class.java,
                "app_database",)
                .fallbackToDestructiveMigration()
                .build()
        return instance!!
    }

    fun getInstance(): AppDatabase {
        if (instance == null) {
            throw IllegalStateException("Database not initialized")
        }
        return instance!!
    }
}

@Database(entities = [IntermediaryCard::class, IntermediaryCategory::class, IntermediaryAttribute::class, User::class], version = 4,
    exportSchema = true)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cardDAO(): cardDAO
    abstract fun categoryDAO(): categoryDAO
    abstract fun attributeDAO(): attributeDAO
    abstract fun userDAO(): userDAO
}