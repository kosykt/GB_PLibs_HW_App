package com.example.gb_plibs_hw_app.di.modules.data.details

import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RoomCacheUserDetailsRepository
import com.example.gb_plibs_hw_app.di.scope.DetailsScope
import dagger.Binds
import dagger.Module

@Module
abstract class BindsDataBaseDetails {
    @DetailsScope
    @Binds
    abstract fun bindsRoomCacheDetails(impl: RoomCacheUserDetailsRepositoryImpl):
            RoomCacheUserDetailsRepository
}