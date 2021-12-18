package com.example.gb_plibs_hw_app.data.db

import com.example.gb_plibs_hw_app.data.db.model.RoomUserDetailsModel
import com.example.gb_plibs_hw_app.data.network.model.NetworkUserDetailsModel
import com.example.gb_plibs_hw_app.data.repository.networkToRoomUserDetailsModel
import io.reactivex.rxjava3.core.Single

class RoomCacheUserDetails(private val db: AppDatabase) {

    fun insertUserDetails(list: List<NetworkUserDetailsModel>) {
        db.userDetailsDao.insert(list.networkToRoomUserDetailsModel())
    }

    fun getUserDetailsById(userId: String): Single<List<RoomUserDetailsModel>> {
        return db.userDetailsDao.getByUserId(userId)
    }
}