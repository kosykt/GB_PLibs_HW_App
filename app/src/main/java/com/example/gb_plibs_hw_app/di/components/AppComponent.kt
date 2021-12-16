package com.example.gb_plibs_hw_app.di.components

import com.example.gb_plibs_hw_app.di.modules.*
import com.example.gb_plibs_hw_app.presentation.ui.main.MainActivity
import com.example.gb_plibs_hw_app.presentation.ui.main.MainPresenter
import com.example.gb_plibs_hw_app.presentation.ui.repodetails.RepoDetailsPresenter
import com.example.gb_plibs_hw_app.presentation.ui.userdetails.UserDetailsPresenter
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersPresenter
import dagger.Component

@Component(
    modules = [
        CacheModule::class,
        CiceroneModule::class,
        ContextModule::class,
        NetworkModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(userDetailsPresenter: UserDetailsPresenter)
    fun inject(repoDetailsPresenter: RepoDetailsPresenter)
}