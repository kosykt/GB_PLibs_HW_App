package com.example.gb_plibs_hw_app.di.modules.domain.details

import com.example.gb_plibs_hw_app.di.scope.DetailsScope
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import com.example.gb_plibs_hw_app.domain.userdetails.usecases.GetGithubUserDetailsUseCase
import dagger.Module
import dagger.Provides

@Module
class UserDetailsUseCaseModule {
    @DetailsScope
    @Provides
    fun getGithubUserDetailsUseCase(
        githubUserDetailsRepository: GithubUserDetailsRepository
    ): GetGithubUserDetailsUseCase {
        return GetGithubUserDetailsUseCase(githubUserDetailsRepository)
    }
}

