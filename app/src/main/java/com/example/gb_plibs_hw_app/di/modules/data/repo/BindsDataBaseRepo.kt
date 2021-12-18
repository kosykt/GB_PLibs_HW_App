package com.example.gb_plibs_hw_app.di.modules.data.repo

import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheRepoDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RoomCacheRepoDetailsRepository
import com.example.gb_plibs_hw_app.di.scope.RepoScope
import dagger.Binds
import dagger.Module

@Module
abstract class BindsDataBaseRepo {
    @RepoScope
    @Binds
    abstract fun bindsRoomCacheRepo(impl: RoomCacheRepoDetailsRepositoryImpl):
            RoomCacheRepoDetailsRepository
}