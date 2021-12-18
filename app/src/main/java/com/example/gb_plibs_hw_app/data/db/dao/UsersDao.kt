package com.example.gb_plibs_hw_app.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gb_plibs_hw_app.data.db.model.RoomUsersModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomUsersModel): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomUsersModel>): Completable

    @Query("SELECT * FROM RoomUsersModel")
    fun getAll(): Single<List<RoomUsersModel>>

    @Query("SELECT * FROM RoomUsersModel WHERE login = :login LIMIT 1")
    fun getByLogin(login: String): RoomUsersModel?
}