package com.example.gb_plibs_hw_app.data.repository

import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersRepository
import com.example.gb_plibs_hw_app.domain.users.model.UserModel
import com.example.gb_plibs_hw_app.data.nerwork.RetrofitService
import io.reactivex.rxjava3.core.Single

class GithubUsersRepositoryImpl(
    private val retrofitService: RetrofitService,
) : GithubUsersRepository {

    override fun getUsersList(): Single<List<UserModel>> {
        return retrofitService.getUsers()
    }
}