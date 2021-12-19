package com.example.gb_plibs_hw_app.data.db.cache

import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RoomCacheRepoDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.toDomainUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RoomCacheRepoDetailsRepositoryImpl @Inject constructor(private val db: AppDatabase) :
    RoomCacheRepoDetailsRepository {

    override fun insertRepoDetails(repoDetails: RoomUserRepoModel): Single<DomainUserRepoModel> {
        return db.repoDetailsDao.insert(repoDetails).toSingle { repoDetails.toDomainUserRepoModel() }
    }

    override fun getRepoDetailsById(repoId: String): Single<RoomUserRepoModel> {
        return db.repoDetailsDao.getRepoId(repoId)
    }
}