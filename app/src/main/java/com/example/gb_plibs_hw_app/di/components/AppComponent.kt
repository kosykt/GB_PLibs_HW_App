package com.example.gb_plibs_hw_app.di.components

import com.example.gb_plibs_hw_app.di.modules.data.DatabaseModule
import com.example.gb_plibs_hw_app.di.modules.data.NetworkModule
import com.example.gb_plibs_hw_app.di.modules.data.details.BindsDataBaseDetails
import com.example.gb_plibs_hw_app.di.modules.data.details.BindsNetworkDetails
import com.example.gb_plibs_hw_app.di.modules.data.repo.BindsDataBaseRepo
import com.example.gb_plibs_hw_app.di.modules.data.repo.BindsNetworkRepo
import com.example.gb_plibs_hw_app.di.modules.data.users.BindsDataBaseUsers
import com.example.gb_plibs_hw_app.di.modules.data.users.BindsNetworkUsers
import com.example.gb_plibs_hw_app.di.modules.domain.details.BindsDetailsUseCase
import com.example.gb_plibs_hw_app.di.modules.domain.details.UserDetailsUseCaseModule
import com.example.gb_plibs_hw_app.di.modules.domain.repo.BindsRepoUseCase
import com.example.gb_plibs_hw_app.di.modules.domain.repo.UserRepoUseCaseModule
import com.example.gb_plibs_hw_app.di.modules.domain.users.BindsUsersUseCase
import com.example.gb_plibs_hw_app.di.modules.domain.users.UsersUseCaseModule
import com.example.gb_plibs_hw_app.di.modules.presentation.CiceroneModule
import com.example.gb_plibs_hw_app.di.modules.presentation.ContextModule
import com.example.gb_plibs_hw_app.presentation.ui.main.MainActivity
import com.example.gb_plibs_hw_app.presentation.ui.main.MainPresenter
import com.example.gb_plibs_hw_app.presentation.ui.repodetails.RepoDetailsPresenterFactory
import com.example.gb_plibs_hw_app.presentation.ui.userdetails.UserDetailsPresenterFactory
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class,
        ContextModule::class,

        DatabaseModule::class,
        NetworkModule::class,

        UsersUseCaseModule::class,
        UserDetailsUseCaseModule::class,
        UserRepoUseCaseModule::class,

        BindsUsersUseCase::class,
        BindsDetailsUseCase::class,
        BindsRepoUseCase::class,

        BindsDataBaseUsers::class,
        BindsDataBaseDetails::class,
        BindsDataBaseRepo::class,

        BindsNetworkUsers::class,
        BindsNetworkDetails::class,
        BindsNetworkRepo::class,

    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun mainPresenter(): MainPresenter
    fun usersPresenter(): UsersPresenter
    fun userDetailsPresenterFactory(): UserDetailsPresenterFactory
    fun repoDetailsPresenterFactory(): RepoDetailsPresenterFactory
}