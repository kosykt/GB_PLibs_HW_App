package com.example.gb_plibs_hw_app.di.modules.data.users

import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.users.repository.RoomCacheUsersListRepository
import com.example.gb_plibs_hw_app.di.scope.UsersScope
import dagger.Binds
import dagger.Module

@Module
abstract class BindsDataBaseUsers {
    @UsersScope
    @Binds
    abstract fun bindsRoomCacheUsers(impl: RoomCacheUsersListRepositoryImpl):
            RoomCacheUsersListRepository

}

