package com.example.gb_plibs_hw_app.data.repository.repodetails

import android.util.Log
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.RepoDetailsRepository
import io.reactivex.rxjava3.core.Single

class RepoDetailsRepositoryImpl(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val db: AppDatabase
) : RepoDetailsRepository {

    override fun getNetWorkRepoDetails(repoUrl: String): Single<DomainUserRepoModel> {
        return retrofitService.getRepo(url = repoUrl)
            .doOnError {
                Log.d("GithubRepoRepositoryImpl", "Ошибка", it)
            }
            .doOnSuccess {
                db.repoDetailsDao.insert(it.toRoomUserRepoModel())
            }
            .map {
                it.toDomainUserRepoModel()
            }
    }

    override fun getDataBaseRepoDetails(repoId: String): Single<DomainUserRepoModel> {
        return Single.fromCallable {
            db.repoDetailsDao.getRepoId(repoId).toDomainUserRepoModel()
        }
    }
}