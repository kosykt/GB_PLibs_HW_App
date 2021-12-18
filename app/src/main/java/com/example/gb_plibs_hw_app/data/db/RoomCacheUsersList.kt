package com.example.gb_plibs_hw_app.data.db

import com.example.gb_plibs_hw_app.data.db.model.RoomUsersModel
import com.example.gb_plibs_hw_app.data.network.model.NetworkUsersModel
import com.example.gb_plibs_hw_app.data.repository.networkToRoomUsersModel
import io.reactivex.rxjava3.core.Single

class RoomCacheUsersList(private val db: AppDatabase) {

    fun insertUsersList(list: List<NetworkUsersModel>) {
        db.usersDao.insert(list.networkToRoomUsersModel())
    }

    fun getUsersList(): Single<List<RoomUsersModel>> {
        return db.usersDao.getAll()
    }
}