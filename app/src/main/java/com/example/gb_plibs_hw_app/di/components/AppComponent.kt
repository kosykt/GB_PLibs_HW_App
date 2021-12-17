package com.example.gb_plibs_hw_app.di.components

import com.example.gb_plibs_hw_app.di.modules.data.DatabaseModule
import com.example.gb_plibs_hw_app.di.modules.data.NetworkModule
import com.example.gb_plibs_hw_app.di.modules.domain.UserDetailsUseCaseModule
import com.example.gb_plibs_hw_app.di.modules.domain.UserRepoUseCaseModule
import com.example.gb_plibs_hw_app.di.modules.domain.UsersUseCaseModule
import com.example.gb_plibs_hw_app.di.modules.presentation.CiceroneModule
import com.example.gb_plibs_hw_app.di.modules.presentation.ContextModule
import com.example.gb_plibs_hw_app.presentation.ui.main.MainActivity
import com.example.gb_plibs_hw_app.presentation.ui.main.MainPresenter
import com.example.gb_plibs_hw_app.presentation.ui.repodetails.RepoDetailsPresenter
import com.example.gb_plibs_hw_app.presentation.ui.userdetails.UserDetailsPresenter
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersPresenter
import dagger.Component

@Component(
    modules = [
        ContextModule::class,
        CiceroneModule::class,
        UserDetailsUseCaseModule::class,
        UserRepoUseCaseModule::class,
        UsersUseCaseModule::class,
        DatabaseModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(userDetailsPresenter: UserDetailsPresenter)
    fun inject(repoDetailsPresenter: RepoDetailsPresenter)
}