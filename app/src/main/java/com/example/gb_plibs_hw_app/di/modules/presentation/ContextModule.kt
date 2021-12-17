package com.example.gb_plibs_hw_app.di.modules.presentation

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val app: Application) {

    @Provides
    fun appContext(): Context {
        return app
    }
}