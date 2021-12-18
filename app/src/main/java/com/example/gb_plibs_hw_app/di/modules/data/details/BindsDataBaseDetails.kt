package com.example.gb_plibs_hw_app.di.modules.data.details

import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RoomCacheUserDetailsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindsDataBaseDetails {
    @Singleton
    @Binds
    abstract fun bindsRoomCacheDetails(impl: RoomCacheUserDetailsRepositoryImpl):
            RoomCacheUserDetailsRepository
}