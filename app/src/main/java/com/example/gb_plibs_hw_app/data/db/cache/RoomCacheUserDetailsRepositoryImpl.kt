package com.example.gb_plibs_hw_app.data.db.cache

import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.db.model.RoomUserDetailsModel
import com.example.gb_plibs_hw_app.data.repository.roomToDomainUserDetailsModel
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RoomCacheUserDetailsRepository
import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RoomCacheUserDetailsRepositoryImpl @Inject constructor(private val db: AppDatabase) :
    RoomCacheUserDetailsRepository {

    override fun insertUserDetails(list: List<RoomUserDetailsModel>): Single<List<DomainUserDetailsModel>> {
        return db.userDetailsDao.insert(list).toSingle { list.roomToDomainUserDetailsModel() }
    }

    override fun getUserDetailsById(userId: String): Single<List<RoomUserDetailsModel>> {
        return db.userDetailsDao.getByUserId(userId)
    }
}