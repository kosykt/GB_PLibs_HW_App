package com.example.gb_plibs_hw_app.data.db

import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel
import com.example.gb_plibs_hw_app.data.network.model.NetworkUserRepoModel
import com.example.gb_plibs_hw_app.data.repository.toRoomUserRepoModel
import io.reactivex.rxjava3.core.Single

class RoomCacheRepoDetails(private val db: AppDatabase) {

    fun insertRepoDetails(repoDetails: NetworkUserRepoModel) {
        db.repoDetailsDao.insert(repoDetails.toRoomUserRepoModel())
    }

    fun getRepoDetailsById(repoId: String): Single<RoomUserRepoModel> {
        return db.repoDetailsDao.getRepoId(repoId)
    }
}