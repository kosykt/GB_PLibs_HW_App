package com.example.gb_plibs_hw_app.di.modules.domain.repo

import com.example.gb_plibs_hw_app.di.containers.RepoContainer
import com.example.gb_plibs_hw_app.di.scope.RepoScope
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import com.example.gb_plibs_hw_app.domain.repodetails.usecases.GetGithubRepoUseCase
import com.example.gb_plibs_hw_app.presentation.App
import dagger.Module
import dagger.Provides

@Module
class UserRepoUseCaseModule {
    @RepoScope
    @Provides
    fun getGithubRepoUseCase(
        githubRepoRepository: GithubRepoRepository
    ): GetGithubRepoUseCase {
        return GetGithubRepoUseCase(githubRepoRepository)
    }

    @RepoScope
    @Provides
    fun repoContainer(app: App): RepoContainer = app
}


