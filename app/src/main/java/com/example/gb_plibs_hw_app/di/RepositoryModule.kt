package com.example.gb_plibs_hw_app.di

import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.repodetails.GithubRepoRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.userdetails.GithubUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.users.GithubUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun githubUsersListRepository(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        db: AppDatabase
    ): GithubUsersListRepository {
        return GithubUsersListRepositoryImpl(networkStatus, retrofitService, db)
    }

    @Provides
    fun githubUserDetailsRepository(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        db: AppDatabase
    ): GithubUserDetailsRepository {
        return GithubUserDetailsRepositoryImpl(networkStatus, retrofitService, db)
    }

    @Provides
    fun githubRepoRepository(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        db: AppDatabase
    ): GithubRepoRepository {
        return GithubRepoRepositoryImpl(networkStatus, retrofitService, db)
    }
}