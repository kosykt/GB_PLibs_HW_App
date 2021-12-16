package com.example.gb_plibs_hw_app.di.modules

import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.userdetails.GithubUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import com.example.gb_plibs_hw_app.domain.userdetails.usecases.GetGithubUserDetailsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserDetailsModule {

    @Singleton
    @Provides
    fun getGithubUserDetailsUseCase(
        githubUserDetailsRepository: GithubUserDetailsRepository
    ): GetGithubUserDetailsUseCase {
        return GetGithubUserDetailsUseCase(githubUserDetailsRepository)
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
}