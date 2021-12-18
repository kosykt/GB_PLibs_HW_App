package com.example.gb_plibs_hw_app.di.modules.domain

import com.example.gb_plibs_hw_app.data.repository.userdetails.GithubUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RetrofitUserDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RoomCacheUserDetailsRepository
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import com.example.gb_plibs_hw_app.domain.userdetails.usecases.GetGithubUserDetailsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserDetailsUseCaseModule {

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
        roomCacheUserDetails: RoomCacheUserDetailsRepository,
        retrofitUserDetailsRepository: RetrofitUserDetailsRepository
    ): GithubUserDetailsRepository {
        return GithubUserDetailsRepositoryImpl(roomCacheUserDetails, retrofitUserDetailsRepository)
    }
}