package com.example.gb_plibs_hw_app.di.modules.data.users

import com.example.gb_plibs_hw_app.data.network.connection.RetrofitUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.users.repository.RetrofitUsersListRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindsNetworkUsers {
    @Singleton
    @Binds
    abstract fun bindsRetrofitUsers(impl: RetrofitUsersListRepositoryImpl):
            RetrofitUsersListRepository
}

