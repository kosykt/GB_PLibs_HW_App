package com.example.gb_plibs_hw_app.data.repository

import com.example.gb_plibs_hw_app.data.nerwork.RetrofitService
import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import io.reactivex.rxjava3.core.Single

class GithubUserDetailsRepositoryImpl(
    private val retrofitService: RetrofitService
) : GithubUserDetailsRepository {

    override fun getDetailsList(reposUrl: String): Single<List<UserDetailsModel>> {
        return retrofitService.getDetails(url = reposUrl)
    }
}