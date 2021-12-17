package com.example.gb_plibs_hw_app.data.repository

import com.example.gb_plibs_hw_app.data.nerwork.RetrofitService
import com.example.gb_plibs_hw_app.domain.repodetails.model.RepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Single

class GetGithubRepoRepositoryImpl(
    private val retrofitService: RetrofitService
) : GithubRepoRepository {

    override fun getRepoDetails(repoUrl: String): Single<RepoModel> {
        return retrofitService.getRepo(url = repoUrl)
    }
}