package com.example.gb_plibs_hw_app.di.modules.domain

import com.example.gb_plibs_hw_app.data.repository.users.GithubUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.users.repository.RetrofitUsersListRepository
import com.example.gb_plibs_hw_app.data.repository.users.repository.RoomCacheUsersListRepository
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

    @Singleton
    @Provides
    fun githubUsersListRepository(
        retrofitUsersListRepository: RetrofitUsersListRepository,
        roomCacheUsersList: RoomCacheUsersListRepository
    ): GithubUsersListRepository {
        return GithubUsersListRepositoryImpl(retrofitUsersListRepository, roomCacheUsersList)
    }
}