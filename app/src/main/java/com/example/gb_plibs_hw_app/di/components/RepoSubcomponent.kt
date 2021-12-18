package com.example.gb_plibs_hw_app.di.components

import com.example.gb_plibs_hw_app.di.modules.data.repo.BindsDataBaseRepo
import com.example.gb_plibs_hw_app.di.modules.data.repo.BindsNetworkRepo
import com.example.gb_plibs_hw_app.di.modules.domain.repo.BindsRepoUseCase
import com.example.gb_plibs_hw_app.di.modules.domain.repo.UserRepoUseCaseModule
import com.example.gb_plibs_hw_app.di.scope.RepoScope
import com.example.gb_plibs_hw_app.presentation.ui.repodetails.RepoDetailsPresenterFactory
import dagger.Subcomponent

@RepoScope
@Subcomponent(
    modules = [
        UserRepoUseCaseModule::class,
        BindsRepoUseCase::class,
        BindsDataBaseRepo::class,
        BindsNetworkRepo::class,
    ]
)
interface RepoSubcomponent {

    fun repoDetailsPresenterFactory(): RepoDetailsPresenterFactory
}