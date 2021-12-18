package com.example.gb_plibs_hw_app.di.modules.domain.users

import com.example.gb_plibs_hw_app.di.scope.UsersScope
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.usecases.GetGithubUsersListUseCase
import dagger.Module
import dagger.Provides

@Module
class UsersUseCaseModule {
    @UsersScope
    @Provides
    fun getGithubUsersListUseCase(usersListRepository: GithubUsersListRepository): GetGithubUsersListUseCase {
        return GetGithubUsersListUseCase(usersListRepository)
    }
}

