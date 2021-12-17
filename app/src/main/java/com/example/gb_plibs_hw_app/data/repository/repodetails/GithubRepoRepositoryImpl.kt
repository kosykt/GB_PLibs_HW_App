package com.example.gb_plibs_hw_app.data.repository.repodetails

import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.toDomainUserRepoModel
import com.example.gb_plibs_hw_app.data.repository.toRoomUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Single

class GithubRepoRepositoryImpl(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val db: AppDatabase
) : GithubRepoRepository {

    override fun getRepoDetails(repoUrl: String, repoId: String): Single<DomainUserRepoModel> {

        return if (networkStatus.isOnline()) {
            retrofitService.getRepo(url = repoUrl)
                .doOnSuccess {
                    db.repoDetailsDao.insert(it.toRoomUserRepoModel())
                }.map {
                    it.toDomainUserRepoModel()
                }
        } else {
            Single.fromCallable {
                db.repoDetailsDao.getRepoId(repoUrl).toDomainUserRepoModel()
            }
        }
    }
}