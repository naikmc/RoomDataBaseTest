package com.example.roomdatabasetest

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}