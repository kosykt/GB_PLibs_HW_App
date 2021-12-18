package com.example.gb_plibs_hw_app.di.modules.data.details

import com.example.gb_plibs_hw_app.data.network.connection.RetrofitUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RetrofitUserDetailsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindsNetworkDetails {
    @Singleton
    @Binds
    abstract fun bindsRetrofitDetails(impl: RetrofitUserDetailsRepositoryImpl):
            RetrofitUserDetailsRepository
}