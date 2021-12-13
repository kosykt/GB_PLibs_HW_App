package com.example.gb_plibs_hw_app.data.repository.users

import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.model.UsersListModel
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubUsersListRepositoryImpl(
    private val retrofitService: RetrofitService,
) : GithubUsersListRepository {

    override fun getUsersList(): Single<List<UsersListModel>> {
        return retrofitService.getUsers()
    }
}