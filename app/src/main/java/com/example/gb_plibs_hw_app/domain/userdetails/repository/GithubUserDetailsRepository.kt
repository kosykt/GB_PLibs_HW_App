package com.example.gb_plibs_hw_app.domain.userdetails.repository

import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import io.reactivex.rxjava3.core.Single

interface GithubUserDetailsRepository {

    fun getDetailsList(reposUrl: String): Single<List<UserDetailsModel>>
}