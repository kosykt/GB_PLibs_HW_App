package com.example.gb_plibs_hw_app.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gb_plibs_hw_app.data.db.model.RoomUserDetailsModel
import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel

@Dao
interface RepoDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(id: RoomUserRepoModel)

    @Query("SELECT * FROM RoomUserRepoModel")
    fun getAll(): RoomUserRepoModel

    @Query("SELECT * FROM RoomUserRepoModel WHERE id = :id")
    fun getRepoId(id: String): RoomUserRepoModel
}