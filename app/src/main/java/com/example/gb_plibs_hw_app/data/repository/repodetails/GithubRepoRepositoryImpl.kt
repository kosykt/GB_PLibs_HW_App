package com.example.gb_plibs_hw_app.data.repository.repodetails

import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.domain.repodetails.model.UserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Single

class GithubRepoRepositoryImpl(
    private val retrofitService: RetrofitService
) : GithubRepoRepository {

    override fun getRepoDetails(repoUrl: String): Single<UserRepoModel> {
        return retrofitService.getRepo(url = repoUrl).map {
            UserRepoModel(forksCount = it.forksCount)
        }
    }
}