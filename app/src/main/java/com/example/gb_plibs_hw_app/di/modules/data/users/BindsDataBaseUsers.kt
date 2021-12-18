package com.example.gb_plibs_hw_app.di.modules.data.users

import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.users.repository.RoomCacheUsersListRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindsDataBaseUsers {

    @Singleton
    @Binds
    abstract fun bindsRoomCacheUsers(impl: RoomCacheUsersListRepositoryImpl):
            RoomCacheUsersListRepository

}

