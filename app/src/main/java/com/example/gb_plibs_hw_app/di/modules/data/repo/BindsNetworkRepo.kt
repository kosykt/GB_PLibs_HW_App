package com.example.gb_plibs_hw_app.di.modules.data.repo

import com.example.gb_plibs_hw_app.data.network.connection.RetrofitRepoDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RetrofitRepoDetailsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindsNetworkRepo {
    @Singleton
    @Binds
    abstract fun bindsRetrofitRepo(impl: RetrofitRepoDetailsRepositoryImpl):
            RetrofitRepoDetailsRepository
}