package com.example.gb_plibs_hw_app.data.db.dao

import androidx.room.*
import com.example.gb_plibs_hw_app.data.db.model.RoomUsersModel

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomUsersModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomUsersModel>)

    @Query("SELECT * FROM RoomUsersModel")
    fun getAll(): List<RoomUsersModel>

    @Query("SELECT * FROM RoomUsersModel WHERE login = :login LIMIT 1")
    fun getByLogin(login: String): RoomUsersModel?
}