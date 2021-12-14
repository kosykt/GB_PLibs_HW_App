package com.example.gb_plibs_hw_app.data.repository.users

import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.model.UsersModel
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import io.reactivex.rxjava3.core.Single

class GithubUsersListRepositoryImpl(
    private val retrofitService: RetrofitService,
) : GithubUsersListRepository {

    override fun getUsersList(): Single<List<UsersModel>> {

        return retrofitService.getUsers()
            .flatMap { listNetworkModel ->
                Single.fromCallable {
                    val returnedList = listNetworkModel.map { networkModel ->
                        UsersModel(
                            login = networkModel.login,
                            avatarUrl = networkModel.avatarUrl,
                            reposUrl = networkModel.reposUrl
                        )
                    }
                    returnedList
                }
            }
    }
}