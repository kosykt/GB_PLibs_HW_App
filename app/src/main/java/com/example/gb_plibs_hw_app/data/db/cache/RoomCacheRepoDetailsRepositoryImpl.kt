package com.example.gb_plibs_hw_app.data.db.cache

import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RoomCacheRepoDetailsRepository
import io.reactivex.rxjava3.core.Single

class RoomCacheRepoDetailsRepositoryImpl(private val db: AppDatabase) :
    RoomCacheRepoDetailsRepository {

    override fun insertRepoDetails(repoDetails: RoomUserRepoModel) {
        db.repoDetailsDao.insert(repoDetails)
    }

    override fun getRepoDetailsById(repoId: String): Single<RoomUserRepoModel> {
        return db.repoDetailsDao.getRepoId(repoId)
    }
}