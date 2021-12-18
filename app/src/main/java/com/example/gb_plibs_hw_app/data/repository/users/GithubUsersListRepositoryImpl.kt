package com.example.gb_plibs_hw_app.data.repository.users

import com.example.gb_plibs_hw_app.data.repository.networkToDomainUsersModel
import com.example.gb_plibs_hw_app.data.repository.networkToRoomUsersModel
import com.example.gb_plibs_hw_app.data.repository.roomToDomainUsersModel
import com.example.gb_plibs_hw_app.data.repository.users.repository.RetrofitUsersListRepository
import com.example.gb_plibs_hw_app.data.repository.users.repository.RoomCacheUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubUsersListRepositoryImpl @Inject constructor(
    private val retrofitUsersListRepository: RetrofitUsersListRepository,
    private val roomCacheUsersList: RoomCacheUsersListRepository
) : GithubUsersListRepository {

    override fun getNetworkUsersList(): Single<List<DomainUsersModel>> {
        return retrofitUsersListRepository.getUsersList()
            .doOnSuccess {
                roomCacheUsersList.insertUsersList(it.networkToRoomUsersModel())
            }
            .map {
                it.networkToDomainUsersModel()
            }
    }

    override fun getDbUsersList(): Single<List<DomainUsersModel>> {
        return roomCacheUsersList.getUsersList()
            .map { it.roomToDomainUsersModel() }
    }
}