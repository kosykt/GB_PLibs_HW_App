package com.example.gb_plibs_hw_app.data.users.repository

import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersRepository
import com.example.gb_plibs_hw_app.domain.users.model.UserModel
import com.example.gb_plibs_hw_app.data.users.nerwork.UsersRetrofitService
import io.reactivex.rxjava3.core.Single

class GithubUsersRepositoryImpl(
    private val retrofitService: UsersRetrofitService,
) : GithubUsersRepository {

    override fun getUsersList(): Single<List<UserModel>> {
        return retrofitService.getUsers()
    }
}