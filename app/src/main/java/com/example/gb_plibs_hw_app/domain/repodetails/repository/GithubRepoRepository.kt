package com.example.gb_plibs_hw_app.domain.repodetails.repository

import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import io.reactivex.rxjava3.core.Single

interface GithubRepoRepository {

    fun getRepoDetails(repoUrl: String, repoId: String): Single<DomainUserRepoModel>
}