package com.example.gb_plibs_hw_app.data.repository.users

import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.networkToDomainUsersModel
import com.example.gb_plibs_hw_app.data.repository.networkToRoomUsersModel
import com.example.gb_plibs_hw_app.data.repository.roomToDomainUsersModel
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import io.reactivex.rxjava3.core.Single

class GithubUsersListRepositoryImpl(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val db: AppDatabase
) : GithubUsersListRepository {

    override fun getUsersList(): Single<List<DomainUsersModel>> {
        return if (networkStatus.isOnline()) {
            retrofitService.getUsers()
                .doOnSuccess {
                    db.usersDao.insert(it.networkToRoomUsersModel())
                }
                .map {
                    it.networkToDomainUsersModel()
                }
        } else {
            Single.fromCallable {
                db.usersDao.getAll().roomToDomainUsersModel()
            }
        }
    }
}