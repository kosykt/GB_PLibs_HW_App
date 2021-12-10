package com.example.gb_plibs_hw_app.domain

import com.example.gb_plibs_hw_app.model.GithubUserModel
import com.example.gb_plibs_hw_app.remote.RetrofitService
import io.reactivex.rxjava3.core.Single

class GithubUsersRepositoryImpl(
    private val retrofitService: RetrofitService,
) : GithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return retrofitService.getUsers()
    }
}