package com.example.gb_plibs_hw_app.domain.userdetails.repository

import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import io.reactivex.rxjava3.core.Single

interface GithubUserDetailsRepository {

    fun getNetworkDetailsList(reposUrl: String): Single<List<DomainUserDetailsModel>>

    fun getDbDetailsList(userId: String): Single<List<DomainUserDetailsModel>>
}