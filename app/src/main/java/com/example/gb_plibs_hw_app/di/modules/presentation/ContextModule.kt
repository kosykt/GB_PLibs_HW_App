package com.example.gb_plibs_hw_app.di.modules.presentation

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(private val app: Application) {

    @Singleton
    @Provides
    fun appContext(): Context {
        return app
    }
}