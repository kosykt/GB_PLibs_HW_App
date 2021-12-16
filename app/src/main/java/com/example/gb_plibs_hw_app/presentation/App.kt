package com.example.gb_plibs_hw_app.presentation

import android.app.Application
import com.example.gb_plibs_hw_app.di.components.AppComponent
import com.example.gb_plibs_hw_app.di.components.DaggerAppComponent
import com.example.gb_plibs_hw_app.di.modules.ContextModule
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    companion object {

        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}