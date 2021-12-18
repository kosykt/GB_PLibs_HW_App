package com.example.gb_plibs_hw_app.data.repository.users.repository

import com.example.gb_plibs_hw_app.data.db.model.RoomUsersModel
import io.reactivex.rxjava3.core.Single

interface RoomCacheUsersListRepository {

    fun insertUsersList(list: List<RoomUsersModel>)

    fun getUsersList(): Single<List<RoomUsersModel>>
}