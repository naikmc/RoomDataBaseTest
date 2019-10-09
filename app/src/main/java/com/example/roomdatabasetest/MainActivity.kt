package com.example.roomdatabasetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataBase: UsersDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataBase =  Room.databaseBuilder(
            applicationContext,
            UsersDatabase::class.java, "Sample.db"
        ).build()

        CoroutineScope(IO).launch {
            for (i in 2.. 20) {

                dataBase.userDao().update(User(i.toString(), "Mahesh"))
            }


            dataBase.close()

            var list = dataBase.userDao().findUserByName("Mahesh")


            println(Arrays.asList(list))
        }
    }
}
