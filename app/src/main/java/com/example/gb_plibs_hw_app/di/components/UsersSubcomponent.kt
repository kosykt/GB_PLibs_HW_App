package com.example.gb_plibs_hw_app.di.components

import com.example.gb_plibs_hw_app.di.modules.data.users.BindsDataBaseUsers
import com.example.gb_plibs_hw_app.di.modules.data.users.BindsNetworkUsers
import com.example.gb_plibs_hw_app.di.modules.domain.users.BindsUsersUseCase
import com.example.gb_plibs_hw_app.di.modules.domain.users.UsersUseCaseModule
import com.example.gb_plibs_hw_app.di.scope.UsersScope
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersPresenter
import dagger.Subcomponent

@UsersScope
@Subcomponent(
    modules = [
        UsersUseCaseModule::class,
        BindsUsersUseCase::class,
        BindsDataBaseUsers::class,
        BindsNetworkUsers::class,
    ]
)
interface UsersSubcomponent {

    fun repoSubcomponent(): RepoSubcomponent

    fun detailsSubcomponent(): DetailsSubcomponent

    fun usersPresenter(): UsersPresenter
}