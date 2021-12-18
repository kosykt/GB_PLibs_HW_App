package com.example.gb_plibs_hw_app.di.components

import com.example.gb_plibs_hw_app.di.modules.data.DatabaseModule
import com.example.gb_plibs_hw_app.di.modules.data.NetworkModule
import com.example.gb_plibs_hw_app.di.modules.data.users.BindsDataBaseUsers
import com.example.gb_plibs_hw_app.di.modules.data.users.BindsNetworkUsers
import com.example.gb_plibs_hw_app.di.modules.domain.users.BindsUsersUseCase
import com.example.gb_plibs_hw_app.di.modules.domain.users.UsersUseCaseModule
import com.example.gb_plibs_hw_app.di.modules.presentation.CiceroneModule
import com.example.gb_plibs_hw_app.di.modules.presentation.ContextModule
import com.example.gb_plibs_hw_app.presentation.ui.main.MainActivity
import com.example.gb_plibs_hw_app.presentation.ui.main.MainPresenter
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        CiceroneModule::class,
        ContextModule::class,
        NetworkModule::class,

        UsersUseCaseModule::class,
        BindsUsersUseCase::class,
        BindsDataBaseUsers::class,
        BindsNetworkUsers::class,
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun mainPresenter(): MainPresenter
    fun usersPresenter(): UsersPresenter
}