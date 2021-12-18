package com.example.gb_plibs_hw_app.data.db

import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel
import com.example.gb_plibs_hw_app.data.network.model.NetworkUserRepoModel
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RoomCacheRepoDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.toRoomUserRepoModel
import io.reactivex.rxjava3.core.Single

class RoomCacheRepoDetailsRepositoryImpl(private val db: AppDatabase) :
    RoomCacheRepoDetailsRepository {

    override fun insertRepoDetails(repoDetails: NetworkUserRepoModel) {
        db.repoDetailsDao.insert(repoDetails.toRoomUserRepoModel())
    }

    override fun getRepoDetailsById(repoId: String): Single<RoomUserRepoModel> {
        return db.repoDetailsDao.getRepoId(repoId)
    }
}