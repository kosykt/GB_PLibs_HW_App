package com.example.gb_plibs_hw_app.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gb_plibs_hw_app.data.db.dao.UserDetailsDao
import com.example.gb_plibs_hw_app.data.db.dao.UsersDao
import com.example.gb_plibs_hw_app.data.db.model.RoomUserDetailsModel
import com.example.gb_plibs_hw_app.data.db.model.RoomUsersModel
import com.example.gb_plibs_hw_app.presentation.App

@Database(
    entities = [
        RoomUsersModel::class,
        RoomUserDetailsModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract val usersDao: UsersDao
    abstract val userDetailsDao: UserDetailsDao

    companion object {
        private const val DB_NAME = "database.db"

        val instance by lazy {
            Room.databaseBuilder(App.instance, AppDatabase::class.java, DB_NAME)
                .build()
        }
    }
}