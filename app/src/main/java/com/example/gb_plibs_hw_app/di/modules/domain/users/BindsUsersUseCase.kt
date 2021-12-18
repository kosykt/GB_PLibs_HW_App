package com.example.gb_plibs_hw_app.di.modules.domain.users

import com.example.gb_plibs_hw_app.data.repository.users.GithubUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.di.scope.UsersScope
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import dagger.Binds
import dagger.Module

@Module
abstract class BindsUsersUseCase {
    @UsersScope
    @Binds
    abstract fun bindsUsersUseCase(impl: GithubUsersListRepositoryImpl): GithubUsersListRepository
}