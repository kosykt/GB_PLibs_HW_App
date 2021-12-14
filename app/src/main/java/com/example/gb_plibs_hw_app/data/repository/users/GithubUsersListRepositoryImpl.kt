package com.example.gb_plibs_hw_app.data.repository.users

import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.db.model.RoomUsersModel
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.model.UsersModel
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import io.reactivex.rxjava3.core.Single

class GithubUsersListRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val db: AppDatabase
) : GithubUsersListRepository {

    override fun getUsersList(): Single<List<UsersModel>> {

        return retrofitService.getUsers()
            .flatMap { listNetworkModel ->
                Single.fromCallable {
                    val roomUsers = listNetworkModel.map { networkModel ->
                        RoomUsersModel(
                            id =networkModel.id,
                            login = networkModel.login,
                            avatarUrl = networkModel.avatarUrl,
                            reposUrl = networkModel.reposUrl
                        )
                    }
                    db.usersDao.insert(roomUsers)

                    val returnedList = listNetworkModel.map { networkModel ->
                        UsersModel(
                            id =networkModel.id,
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