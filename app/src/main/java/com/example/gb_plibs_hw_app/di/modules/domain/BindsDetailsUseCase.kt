package com.example.gb_plibs_hw_app.di.modules.domain

import com.example.gb_plibs_hw_app.data.repository.userdetails.GithubUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindsDetailsUseCase {

    @Singleton
    @Binds
    abstract fun bindsDetailsUseCase(impl: GithubUserDetailsRepositoryImpl): GithubUserDetailsRepository
}