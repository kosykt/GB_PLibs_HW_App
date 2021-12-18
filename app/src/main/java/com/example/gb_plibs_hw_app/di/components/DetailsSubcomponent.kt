package com.example.gb_plibs_hw_app.di.components

import com.example.gb_plibs_hw_app.di.modules.data.details.BindsDataBaseDetails
import com.example.gb_plibs_hw_app.di.modules.data.details.BindsNetworkDetails
import com.example.gb_plibs_hw_app.di.modules.domain.details.BindsDetailsUseCase
import com.example.gb_plibs_hw_app.di.modules.domain.details.UserDetailsUseCaseModule
import com.example.gb_plibs_hw_app.di.scope.DetailsScope
import com.example.gb_plibs_hw_app.presentation.ui.userdetails.UserDetailsPresenterFactory
import dagger.Subcomponent

@DetailsScope
@Subcomponent(
    modules = [
        UserDetailsUseCaseModule::class,
        BindsDetailsUseCase::class,
        BindsDataBaseDetails::class,
        BindsNetworkDetails::class,
    ]
)
interface DetailsSubcomponent {

    fun repoSubcomponent(): RepoSubcomponent

    fun userDetailsPresenterFactory(): UserDetailsPresenterFactory
}