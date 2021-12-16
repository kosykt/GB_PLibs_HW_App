package com.example.gb_plibs_hw_app.domain.repodetails.usecases

import com.example.gb_plibs_hw_app.domain.repodetails.model.UserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Single

class GetGithubRepoUseCase(private val repository: GithubRepoRepository) {

    fun execute(repoUrl: String, repoId: String): Single<UserRepoModel> =
        repository.getRepoDetails(repoUrl = repoUrl, repoId = repoId)
}