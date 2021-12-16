package com.example.gb_plibs_hw_app.di.modules

import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.repodetails.GithubRepoRepositoryImpl
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import com.example.gb_plibs_hw_app.domain.repodetails.usecases.GetGithubRepoUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoDetailsUseCaseModule {

    @Singleton
    @Provides
    fun getGithubRepoUseCase(
        githubRepoRepository: GithubRepoRepository
    ): GetGithubRepoUseCase {
        return GetGithubRepoUseCase(githubRepoRepository)
    }

    @Singleton
    @Provides
    fun githubRepoRepository(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        db: AppDatabase
    ): GithubRepoRepository {
        return GithubRepoRepositoryImpl(networkStatus, retrofitService, db)
    }
}