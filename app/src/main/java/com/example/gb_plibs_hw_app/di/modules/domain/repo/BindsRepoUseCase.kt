package com.example.gb_plibs_hw_app.di.modules.domain.repo

import com.example.gb_plibs_hw_app.data.repository.repodetails.GithubRepoRepositoryImpl
import com.example.gb_plibs_hw_app.di.scope.RepoScope
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import dagger.Binds
import dagger.Module

@Module
abstract class BindsRepoUseCase {
    @RepoScope
    @Binds
    abstract fun bindsRepoUseCase(impl: GithubRepoRepositoryImpl): GithubRepoRepository
}