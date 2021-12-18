package com.example.gb_plibs_hw_app.di.modules.data.users

import com.example.gb_plibs_hw_app.data.network.connection.RetrofitUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.users.repository.RetrofitUsersListRepository
import com.example.gb_plibs_hw_app.di.scope.UsersScope
import dagger.Binds
import dagger.Module

@Module
abstract class BindsNetworkUsers {
    @UsersScope
    @Binds
    abstract fun bindsRetrofitUsers(impl: RetrofitUsersListRepositoryImpl):
            RetrofitUsersListRepository
}

