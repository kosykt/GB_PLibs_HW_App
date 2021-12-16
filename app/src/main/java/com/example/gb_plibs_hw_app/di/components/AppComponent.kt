package com.example.gb_plibs_hw_app.di.components

import com.example.gb_plibs_hw_app.di.modules.*
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
        CacheModule::class,
        CiceroneModule::class,
        ContextModule::class,
        NetworkModule::class,
        UserDetailsModule::class,
        UsersListUseCaseModule::class,
        RepoDetailsUseCaseModule::class,
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun mainPresenter(): MainPresenter
    fun usersPresenter(): UsersPresenter
    fun userDetailsPresenterFactory(): UserDetailsPresenterFactory
    fun repoDetailsPresenterFactory(): RepoDetailsPresenterFactory
}