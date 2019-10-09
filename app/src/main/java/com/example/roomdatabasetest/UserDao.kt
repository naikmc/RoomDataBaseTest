package com.example.roomdatabasetest

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)
    @Update
    fun update(user: User)
    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users"+
    " WHERE userName LIKE :userName")
    fun findUserByName(userName: String ): List<User>

}