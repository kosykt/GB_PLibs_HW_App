package com.example.gb_plibs_hw_app.di.modules.data

import com.example.gb_plibs_hw_app.data.network.connection.RetrofitRepoDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.network.connection.RetrofitUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.network.connection.RetrofitUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RetrofitRepoDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RetrofitUserDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.users.repository.RetrofitUsersListRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindsNetwork {

    @Singleton
    @Binds
    abstract fun bindsRetrofitUsers(impl: RetrofitUsersListRepositoryImpl):
            RetrofitUsersListRepository

    @Singleton
    @Binds
    abstract fun bindsRetrofitDetails(impl: RetrofitUserDetailsRepositoryImpl):
            RetrofitUserDetailsRepository

    @Singleton
    @Binds
    abstract fun bindsRetrofitRepo(impl: RetrofitRepoDetailsRepositoryImpl):
            RetrofitRepoDetailsRepository
}