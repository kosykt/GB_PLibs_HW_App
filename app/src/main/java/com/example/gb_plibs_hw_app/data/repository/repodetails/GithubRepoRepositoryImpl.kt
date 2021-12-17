package com.example.gb_plibs_hw_app.data.repository.repodetails

import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.domain.repodetails.model.UserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Single

class GithubRepoRepositoryImpl(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val db: AppDatabase
) : GithubRepoRepository {

    override fun getRepoDetails(repoUrl: String, repoId: String): Single<UserRepoModel> {

        return if (networkStatus.isOnline()) {
            retrofitService.getRepo(url = repoUrl).map { networkModel ->
                db.repoDetailsDao.insert(
                    RoomUserRepoModel(
                        id = networkModel.id,
                        forksCount = networkModel.forksCount
                    )
                )
                UserRepoModel(id = networkModel.id, forksCount = networkModel.forksCount)
            }
        } else {
            Single.fromCallable {
                UserRepoModel(
                    id = db.repoDetailsDao.getRepoId(repoId).id,
                    forksCount = db.repoDetailsDao.getRepoId(repoId).forksCount
                )
            }
        }
    }
}