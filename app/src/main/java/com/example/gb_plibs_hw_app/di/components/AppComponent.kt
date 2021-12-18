package com.example.gb_plibs_hw_app.di.components

import com.example.gb_plibs_hw_app.di.modules.data.DatabaseModule
import com.example.gb_plibs_hw_app.di.modules.data.NetworkModule
import com.example.gb_plibs_hw_app.di.modules.presentation.CiceroneModule
import com.example.gb_plibs_hw_app.di.modules.presentation.ContextModule
import com.example.gb_plibs_hw_app.presentation.ui.main.MainActivity
import com.example.gb_plibs_hw_app.presentation.ui.main.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        CiceroneModule::class,
        ContextModule::class,
        NetworkModule::class,
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun mainPresenter(): MainPresenter
}