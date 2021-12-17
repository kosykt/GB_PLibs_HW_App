package com.example.gb_plibs_hw_app.domain.repodetails.usecases

import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import io.reactivex.rxjava3.core.Single

class GetGithubRepoUseCase(private val repoRepository: GithubRepoRepository) {

    fun execute(repoUrl: String, repoId: String, network: Boolean): Single<DomainUserRepoModel> {
        return when (network) {
            true -> repoRepository.getNetworkRepoDetails(repoUrl)
            false -> repoRepository.getDbRepoDetails(repoId)
        }
    }
}