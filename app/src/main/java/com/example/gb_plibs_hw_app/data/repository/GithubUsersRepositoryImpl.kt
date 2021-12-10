package com.example.gb_plibs_hw_app.data.repository

import com.example.gb_plibs_hw_app.domain.repository.GithubUsersRepository
import com.example.gb_plibs_hw_app.domain.model.GithubUserModel
import com.example.gb_plibs_hw_app.data.nerwork.RetrofitService
import io.reactivex.rxjava3.core.Single

class GithubUsersRepositoryImpl(
    private val retrofitService: RetrofitService,
) : GithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return retrofitService.getUsers()
    }
}