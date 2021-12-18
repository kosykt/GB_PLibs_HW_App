package com.example.gb_plibs_hw_app.di.modules.domain

import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.repodetails.GithubRepoRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RoomCacheRepoDetailsRepository
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import com.example.gb_plibs_hw_app.domain.repodetails.usecases.GetGithubRepoUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserRepoUseCaseModule {

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
        roomCacheRepoDetails: RoomCacheRepoDetailsRepository,
        retrofitService: RetrofitService,
    ): GithubRepoRepository {
        return GithubRepoRepositoryImpl(roomCacheRepoDetails, retrofitService)
    }
}