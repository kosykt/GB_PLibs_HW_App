package com.example.gb_plibs_hw_app.di.modules.domain

import com.example.gb_plibs_hw_app.data.repository.users.GithubUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.usecases.GetGithubUsersListUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UsersUseCaseModule {

    @Singleton
    @Provides
    fun getGithubUsersListUseCase(usersListRepository: GithubUsersListRepository): GetGithubUsersListUseCase {
        return GetGithubUsersListUseCase(usersListRepository)
    }
}

@Module
abstract class BindsUsersUseCase {

    @Singleton
    @Binds
    abstract fun bindsUsersUseCase(impl: GithubUsersListRepositoryImpl): GithubUsersListRepository
}