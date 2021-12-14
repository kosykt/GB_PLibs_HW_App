package com.example.gb_plibs_hw_app.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gb_plibs_hw_app.data.db.dao.UsersDao
import com.example.gb_plibs_hw_app.data.db.model.RoomUsersModel
import com.example.gb_plibs_hw_app.presentation.App

@Database(entities = [RoomUsersModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UsersDao

    companion object{
        private const val DB_NAME = "database.db"

        val instance by lazy {
            Room.databaseBuilder(App.instance, AppDatabase::class.java, DB_NAME)
                .build()
        }
    }
}