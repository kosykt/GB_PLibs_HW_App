package com.example.gb_plibs_hw_app.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gb_plibs_hw_app.data.db.model.RoomUserDetailsModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface UserDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(id: RoomUserDetailsModel): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(id: List<RoomUserDetailsModel>): Completable

    @Query("SELECT * FROM RoomUserDetailsModel")
    fun getAll(): Single<List<RoomUserDetailsModel>>

    @Query("SELECT * FROM RoomUserDetailsModel WHERE userId = :userId")
    fun getByUserId(userId: String): Single<List<RoomUserDetailsModel>>
}