package com.example.gb_plibs_hw_app.di.modules.domain

import com.example.gb_plibs_hw_app.data.repository.repodetails.GithubRepoRepositoryImpl
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindsRepoUseCase {

    @Singleton
    @Binds
    abstract fun bindsRepoUseCase(impl: GithubRepoRepositoryImpl): GithubRepoRepository
}