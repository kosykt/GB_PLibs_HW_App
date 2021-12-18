package com.example.gb_plibs_hw_app.di.modules.presentation

import android.content.Context
import com.example.gb_plibs_hw_app.presentation.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(private val app: App) {

    @Singleton
    @Provides
    fun appContext(): Context {
        return app
    }

    @Singleton
    @Provides
    fun app(): App {
        return app
    }
}