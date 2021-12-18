package com.example.gb_plibs_hw_app.di.modules.domain

import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.usecases.GetGithubUsersListUseCase
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

