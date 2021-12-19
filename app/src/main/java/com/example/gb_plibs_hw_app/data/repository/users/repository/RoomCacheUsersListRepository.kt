package com.example.gb_plibs_hw_app.data.repository.users.repository

import com.example.gb_plibs_hw_app.data.db.model.RoomUsersModel
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import io.reactivex.rxjava3.core.Single

interface RoomCacheUsersListRepository {

    fun insertUsersList(list: List<RoomUsersModel>): Single<List<DomainUsersModel>>

    fun getUsersList(): Single<List<RoomUsersModel>>
}