package com.example.gb_plibs_hw_app.data.repository.repodetails

import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.domain.repodetails.model.UserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Single

class GithubRepoRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val db: AppDatabase
) : GithubRepoRepository {

    override fun getRepoDetails(repoUrl: String): Single<UserRepoModel> {

        return retrofitService.getRepo(url = repoUrl).map { networkModel ->
            db.repoDetailsDao.insert(
                RoomUserRepoModel(
                    id = networkModel.id,
                    forksCount = networkModel.forksCount
                )
            )
            UserRepoModel(id = networkModel.id, forksCount = networkModel.forksCount)
        }
    }
}