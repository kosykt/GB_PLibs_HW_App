package com.example.gb_plibs_hw_app.data.repository.repodetails.repository

import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel
import io.reactivex.rxjava3.core.Single

interface RoomCacheRepoDetailsRepository {

    fun insertRepoDetails(repoDetails: RoomUserRepoModel)

    fun getRepoDetailsById(repoId: String): Single<RoomUserRepoModel>
}