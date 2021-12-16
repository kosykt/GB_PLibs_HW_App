package com.example.gb_plibs_hw_app.di.modules

import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.users.GithubUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.usecases.GetGithubUsersListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UsersListUseCaseModule {

    @Singleton
    @Provides
    fun getGithubUsersListUseCase(
        githubUsersListRepository: GithubUsersListRepository
    ): GetGithubUsersListUseCase {
        return GetGithubUsersListUseCase(githubUsersListRepository)
    }

    @Singleton
    @Provides
    fun githubUsersListRepository(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        db: AppDatabase
    ): GithubUsersListRepository {
        return GithubUsersListRepositoryImpl(networkStatus, retrofitService, db)
    }
}