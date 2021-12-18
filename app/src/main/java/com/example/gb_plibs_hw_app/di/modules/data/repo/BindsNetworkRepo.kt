package com.example.gb_plibs_hw_app.di.modules.data.repo

import com.example.gb_plibs_hw_app.data.network.connection.RetrofitRepoDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RetrofitRepoDetailsRepository
import com.example.gb_plibs_hw_app.di.scope.RepoScope
import dagger.Binds
import dagger.Module

@Module
abstract class BindsNetworkRepo {
    @RepoScope
    @Binds
    abstract fun bindsRetrofitRepo(impl: RetrofitRepoDetailsRepositoryImpl):
            RetrofitRepoDetailsRepository
}