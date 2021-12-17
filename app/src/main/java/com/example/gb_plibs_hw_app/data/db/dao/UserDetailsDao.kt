package com.example.gb_plibs_hw_app.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gb_plibs_hw_app.data.db.model.RoomUserDetailsModel

@Dao
interface UserDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(id: RoomUserDetailsModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(id: List<RoomUserDetailsModel>)

    @Query("SELECT * FROM RoomUserDetailsModel")
    fun getAll(): List<RoomUserDetailsModel>

    @Query("SELECT * FROM RoomUserDetailsModel WHERE userId = :userId")
    fun getByUserId(userId: String): List<RoomUserDetailsModel>
}