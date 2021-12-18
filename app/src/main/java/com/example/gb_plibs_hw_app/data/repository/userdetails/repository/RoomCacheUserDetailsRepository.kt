package com.example.gb_plibs_hw_app.data.repository.userdetails.repository

import com.example.gb_plibs_hw_app.data.db.model.RoomUserDetailsModel
import io.reactivex.rxjava3.core.Single

interface RoomCacheUserDetailsRepository {

    fun insertUserDetails(list: List<RoomUserDetailsModel>)

    fun getUserDetailsById(userId: String): Single<List<RoomUserDetailsModel>>
}