package com.example.gb_plibs_hw_app.data.db.cache

import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.db.model.RoomUserDetailsModel
import com.example.gb_plibs_hw_app.data.network.retrofit.model.NetworkUserDetailsModel
import com.example.gb_plibs_hw_app.data.repository.networkToRoomUserDetailsModel
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RoomCacheUserDetailsRepository
import io.reactivex.rxjava3.core.Single

class RoomCacheUserDetailsRepositoryImpl(private val db: AppDatabase) :
    RoomCacheUserDetailsRepository {

    override fun insertUserDetails(list: List<NetworkUserDetailsModel>) {
        db.userDetailsDao.insert(list.networkToRoomUserDetailsModel())
    }

    override fun getUserDetailsById(userId: String): Single<List<RoomUserDetailsModel>> {
        return db.userDetailsDao.getByUserId(userId)
    }
}