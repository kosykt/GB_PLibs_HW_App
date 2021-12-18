package com.example.gb_plibs_hw_app.di.modules.domain.details

import com.example.gb_plibs_hw_app.data.repository.userdetails.GithubUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.di.scope.DetailsScope
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class BindsDetailsUseCase {
    @DetailsScope
    @Binds
    abstract fun bindsDetailsUseCase(impl: GithubUserDetailsRepositoryImpl): GithubUserDetailsRepository
}