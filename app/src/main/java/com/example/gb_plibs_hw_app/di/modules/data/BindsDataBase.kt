package com.example.gb_plibs_hw_app.di.modules.data

import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheRepoDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RoomCacheRepoDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RoomCacheUserDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.users.repository.RoomCacheUsersListRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindsDataBase {

    @Singleton
    @Binds
    abstract fun bindsRoomCacheUsers(impl: RoomCacheUsersListRepositoryImpl):
            RoomCacheUsersListRepository

    @Singleton
    @Binds
    abstract fun bindsRoomCacheDetails(impl: RoomCacheUserDetailsRepositoryImpl):
            RoomCacheUserDetailsRepository

    @Singleton
    @Binds
    abstract fun bindsRoomCacheRepo(impl: RoomCacheRepoDetailsRepositoryImpl):
            RoomCacheRepoDetailsRepository
}