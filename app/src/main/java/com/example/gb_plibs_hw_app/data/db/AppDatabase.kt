package com.example.gb_plibs_hw_app.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gb_plibs_hw_app.data.db.dao.RepoDetailsDao
import com.example.gb_plibs_hw_app.data.db.dao.UserDetailsDao
import com.example.gb_plibs_hw_app.data.db.dao.UsersDao
import com.example.gb_plibs_hw_app.data.db.model.RoomUserDetailsModel
import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel
import com.example.gb_plibs_hw_app.data.db.model.RoomUsersModel

@Database(
    entities = [
        RoomUsersModel::class,
        RoomUserDetailsModel::class,
        RoomUserRepoModel::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract val usersDao: UsersDao
    abstract val userDetailsDao: UserDetailsDao
    abstract val repoDetailsDao: RepoDetailsDao

}