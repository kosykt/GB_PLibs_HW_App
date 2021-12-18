package com.example.gb_plibs_hw_app.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface RepoDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(id: RoomUserRepoModel): Completable

    @Query("SELECT * FROM RoomUserRepoModel")
    fun getAll(): Single<RoomUserRepoModel>

    @Query("SELECT * FROM RoomUserRepoModel WHERE id = :id")
    fun getRepoId(id: String): Single<RoomUserRepoModel>
}