package com.example.gb_plibs_hw_app.di.modules.domain

import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.userdetails.GithubUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import com.example.gb_plibs_hw_app.domain.userdetails.usecases.GetGithubUserDetailsUseCase
import dagger.Module
import dagger.Provides

@Module
class UserDetailsUseCaseModule {

    @Provides
    fun detailsUseCase(
        userDetailsRepository: GithubUserDetailsRepository
    ): GetGithubUserDetailsUseCase {
        return GetGithubUserDetailsUseCase(userDetailsRepository)
    }

    @Provides
    fun userDetailsRepository(
        retrofitService: RetrofitService,
        db: AppDatabase
    ): GithubUserDetailsRepository {
        return GithubUserDetailsRepositoryImpl(retrofitService, db)
    }
}