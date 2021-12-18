package com.example.gb_plibs_hw_app.data.repository.repodetails

import com.example.gb_plibs_hw_app.data.db.RoomCacheRepoDetails
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.toDomainUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Single

class GithubRepoRepositoryImpl(
    private val roomCache: RoomCacheRepoDetails,
    private val retrofitService: RetrofitService
) : GithubRepoRepository {

    override fun getNetworkRepoDetails(repoUrl: String): Single<DomainUserRepoModel> {
        return retrofitService.getRepo(url = repoUrl)
            .doOnSuccess {
                roomCache.insertRepoDetails(it)
            }.map {
                it.toDomainUserRepoModel()
            }
    }

    override fun getDbRepoDetails(repoId: String): Single<DomainUserRepoModel> {
        return roomCache.getRepoDetails(repoId)
            .map { it.toDomainUserRepoModel() }
    }
}