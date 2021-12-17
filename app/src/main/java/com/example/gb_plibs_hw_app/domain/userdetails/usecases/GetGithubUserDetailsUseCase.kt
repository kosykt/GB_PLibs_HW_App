package com.example.gb_plibs_hw_app.domain.userdetails.usecases

import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import io.reactivex.rxjava3.core.Single

class GetGithubUserDetailsUseCase(private val userDetailsRepository: GithubUserDetailsRepository) {

    fun execute(
        userReposUrl: String, userId: String, network: Boolean
    ): Single<List<DomainUserDetailsModel>> {
        return when (network) {
            true -> userDetailsRepository.getNetworkDetailsList(userReposUrl)
            false -> userDetailsRepository.getDbDetailsList(userId)
        }
    }
}