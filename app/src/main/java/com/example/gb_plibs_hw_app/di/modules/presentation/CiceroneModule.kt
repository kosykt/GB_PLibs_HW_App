package com.example.gb_plibs_hw_app.di.modules.presentation

import com.example.gb_plibs_hw_app.presentation.AppScreensRepository
import com.example.gb_plibs_hw_app.presentation.AppScreensRepositoryImpl
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class CiceroneModule {

    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

    @Provides
    fun navigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    @Provides
    fun router(): Router {
        return cicerone.router
    }

    @Provides
    fun appScreensRepository(): AppScreensRepository {
        return AppScreensRepositoryImpl()
    }
}