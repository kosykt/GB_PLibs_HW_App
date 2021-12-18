package com.example.gb_plibs_hw_app.di.modules.domain.users

import com.example.gb_plibs_hw_app.data.repository.users.GithubUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindsUsersUseCase {

    @Singleton
    @Binds
    abstract fun bindsUsersUseCase(impl: GithubUsersListRepositoryImpl): GithubUsersListRepository
}