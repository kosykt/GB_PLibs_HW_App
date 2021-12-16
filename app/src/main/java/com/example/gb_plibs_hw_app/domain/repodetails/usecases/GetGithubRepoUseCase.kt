package com.example.gb_plibs_hw_app.domain.repodetails.usecases

import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.RepoDetailsRepository
import io.reactivex.rxjava3.core.Single

class GetGithubRepoUseCase(private val repoDetailsRepository: RepoDetailsRepository) {

    fun execute(repoUrl: String): Single<DomainUserRepoModel> =
        repoDetailsRepository.getNetWorkRepoDetails(repoUrl = repoUrl)
}