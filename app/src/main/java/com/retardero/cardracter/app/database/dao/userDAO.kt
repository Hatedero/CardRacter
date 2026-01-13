package com.retardero.cardracter.app.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.retardero.cardracter.app.model.User
import com.retardero.cardracter.app.model.Users

@Dao
interface userDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User) : Long

    @Update
    suspend fun updateUser(user:User)

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun get(id : Int): User

    @Delete
    suspend fun delete(user:User)
}