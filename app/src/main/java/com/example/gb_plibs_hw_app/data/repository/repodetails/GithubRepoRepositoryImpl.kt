package com.example.gb_plibs_hw_app.data.repository.repodetails

import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.toDomainUserRepoModel
import com.example.gb_plibs_hw_app.data.repository.toRoomUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Single

class GithubRepoRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val db: AppDatabase
) : GithubRepoRepository {

    override fun getNetworkRepoDetails(repoUrl: String): Single<DomainUserRepoModel> {
        return retrofitService.getRepo(url = repoUrl)
            .doOnSuccess {
                db.repoDetailsDao.insert(it.toRoomUserRepoModel())
            }.map {
                it.toDomainUserRepoModel()
            }
    }

    override fun getDbRepoDetails(repoId: String): Single<DomainUserRepoModel> {
        return Single.fromCallable {
            db.repoDetailsDao.getRepoId(repoId).toDomainUserRepoModel()
        }
    }

}