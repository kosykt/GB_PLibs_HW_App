package com.example.gb_plibs_hw_app.presentation

import android.app.Application
import com.example.gb_plibs_hw_app.di.components.*
import com.example.gb_plibs_hw_app.di.containers.DetailsContainer
import com.example.gb_plibs_hw_app.di.containers.RepoContainer
import com.example.gb_plibs_hw_app.di.containers.UsersContainer
import com.example.gb_plibs_hw_app.di.modules.presentation.ContextModule

class App : Application(), UsersContainer, DetailsContainer, RepoContainer {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

    var usersSubcomponent: UsersSubcomponent? = null
    var detailsSubcomponent: DetailsSubcomponent? = null
    var repoSubcomponent: RepoSubcomponent? = null

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    override fun initUsersSubcomponent() = appComponent.usersSubcomponent().also {
        usersSubcomponent = it
    }

    override fun destroyUsersSubcomponent() {
        usersSubcomponent = null
    }

    override fun initDetailsSubcomponent() =
        appComponent.usersSubcomponent().detailsSubcomponent().also {
            detailsSubcomponent = it
        }

    override fun destroyDetailsSubcomponent() {
        detailsSubcomponent = null
    }

    override fun initRepoSubcomponent() =
        appComponent.usersSubcomponent().detailsSubcomponent().repoSubcomponent().also {
            repoSubcomponent = it
        }

    override fun destroyRepoSubcomponent() {
        repoSubcomponent = null
    }

    companion object {

        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}