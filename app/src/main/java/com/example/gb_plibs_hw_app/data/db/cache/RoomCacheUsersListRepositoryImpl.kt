package com.example.gb_plibs_hw_app.data.db.cache

import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.db.model.RoomUsersModel
import com.example.gb_plibs_hw_app.data.repository.roomToDomainUsersModel
import com.example.gb_plibs_hw_app.data.repository.users.repository.RoomCacheUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RoomCacheUsersListRepositoryImpl @Inject constructor(private val db: AppDatabase) :
    RoomCacheUsersListRepository {

    override fun insertUsersList(list: List<RoomUsersModel>): Single<List<DomainUsersModel>> {
        return db.usersDao.insert(list).toSingle { list.roomToDomainUsersModel() }
    }

    override fun getUsersList(): Single<List<RoomUsersModel>> {
        return db.usersDao.getAll()
    }
}