package com.example.gb_plibs_hw_app.di.modules.data.repo

import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheRepoDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RoomCacheRepoDetailsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindsDataBaseRepo {
    @Singleton
    @Binds
    abstract fun bindsRoomCacheRepo(impl: RoomCacheRepoDetailsRepositoryImpl):
            RoomCacheRepoDetailsRepository
}