package com.example.gb_plibs_hw_app.di.modules

import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.repodetails.RepoDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.userdetails.GithubUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.users.GithubUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.domain.repodetails.repository.RepoDetailsRepository
import com.example.gb_plibs_hw_app.domain.repodetails.usecases.GetGithubRepoUseCase
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import com.example.gb_plibs_hw_app.domain.userdetails.usecases.GetGithubUserDetailsUseCase
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.usecases.GetGithubUsersListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun getGithubUsersListUseCase(
        githubUsersListRepository: GithubUsersListRepository
    ): GetGithubUsersListUseCase {
        return GetGithubUsersListUseCase(githubUsersListRepository)
    }

    @Singleton
    @Provides
    fun getGithubUserDetailsUseCase(
        githubUserDetailsRepository: GithubUserDetailsRepository
    ): GetGithubUserDetailsUseCase {
        return GetGithubUserDetailsUseCase(githubUserDetailsRepository)
    }

    @Singleton
    @Provides
    fun getGithubRepoUseCase(
        repoDetailsRepository: RepoDetailsRepository
    ): GetGithubRepoUseCase {
        return GetGithubRepoUseCase(repoDetailsRepository)
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

    @Singleton
    @Provides
    fun githubUserDetailsRepository(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        db: AppDatabase
    ): GithubUserDetailsRepository {
        return GithubUserDetailsRepositoryImpl(networkStatus, retrofitService, db)
    }

    @Singleton
    @Provides
    fun githubRepoRepository(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        db: AppDatabase
    ): RepoDetailsRepository {
        return RepoDetailsRepositoryImpl(networkStatus, retrofitService, db)
    }
}