package com.example.gb_plibs_hw_app.data.repository.repodetails

import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RetrofitRepoDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RoomCacheRepoDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.toDomainUserRepoModel
import com.example.gb_plibs_hw_app.data.repository.toRoomUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubRepoRepositoryImpl @Inject constructor(
    private val roomCacheRepoDetails: RoomCacheRepoDetailsRepository,
    private val retrofitRepoDetailsRepository: RetrofitRepoDetailsRepository
) : GithubRepoRepository {

    override fun getNetworkRepoDetails(repoUrl: String): Single<DomainUserRepoModel> {
        return retrofitRepoDetailsRepository.getRepoDetails(repoUrl)
            .flatMap {
                roomCacheRepoDetails.insertRepoDetails(it.toRoomUserRepoModel())
            }
    }

    override fun getDbRepoDetails(repoId: String): Single<DomainUserRepoModel> {
        return roomCacheRepoDetails.getRepoDetailsById(repoId)
            .map { it.toDomainUserRepoModel() }
    }
}