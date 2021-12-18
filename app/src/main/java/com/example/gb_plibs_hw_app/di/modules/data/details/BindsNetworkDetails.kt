package com.example.gb_plibs_hw_app.di.modules.data.details

import com.example.gb_plibs_hw_app.data.network.connection.RetrofitUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RetrofitUserDetailsRepository
import com.example.gb_plibs_hw_app.di.scope.DetailsScope
import dagger.Binds
import dagger.Module

@Module
abstract class BindsNetworkDetails {
    @DetailsScope
    @Binds
    abstract fun bindsRetrofitDetails(impl: RetrofitUserDetailsRepositoryImpl):
            RetrofitUserDetailsRepository
}