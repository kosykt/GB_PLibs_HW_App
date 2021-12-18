package com.example.gb_plibs_hw_app.di.modules.domain

import com.example.gb_plibs_hw_app.data.db.RoomCacheUsersList
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.users.GithubUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.usecases.GetGithubUsersListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UsersUseCaseModule {

    @Singleton
    @Provides
    fun usersUseCase(usersListRepository: GithubUsersListRepository): GetGithubUsersListUseCase {
        return GetGithubUsersListUseCase(usersListRepository)
    }

    @Singleton
    @Provides
    fun usersListRepository(
        retrofitService: RetrofitService,
        roomCacheUsersList: RoomCacheUsersList
    ): GithubUsersListRepository {
        return GithubUsersListRepositoryImpl(retrofitService, roomCacheUsersList)
    }
}