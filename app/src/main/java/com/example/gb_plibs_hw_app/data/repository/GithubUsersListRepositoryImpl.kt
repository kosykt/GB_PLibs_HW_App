package com.example.gb_plibs_hw_app.data.repository

import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.model.UsersListModel
import com.example.gb_plibs_hw_app.data.nerwork.RetrofitService
import io.reactivex.rxjava3.core.Single

class GithubUsersListRepositoryImpl(
    private val retrofitService: RetrofitService,
) : GithubUsersListRepository {

    override fun getUsersList(): Single<List<UsersListModel>> {
        return retrofitService.getUsers()
    }
}