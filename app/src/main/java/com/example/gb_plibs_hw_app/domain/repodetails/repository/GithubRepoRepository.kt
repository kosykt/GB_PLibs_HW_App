package com.example.gb_plibs_hw_app.domain.repodetails.repository

import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import io.reactivex.rxjava3.core.Single

interface GithubRepoRepository {

    fun getNetworkRepoDetails(repoUrl: String): Single<DomainUserRepoModel>

    fun getDbRepoDetails(repoId: String): Single<DomainUserRepoModel>
}