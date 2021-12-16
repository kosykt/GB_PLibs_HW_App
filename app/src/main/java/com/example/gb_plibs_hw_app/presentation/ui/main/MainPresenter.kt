package com.example.gb_plibs_hw_app.presentation.ui.main

import com.example.gb_plibs_hw_app.presentation.AppScreensRepository
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.example.gb_plibs_hw_app.presentation.AppScreensRepositoryImpl
import com.github.terrakok.cicerone.androidx.AppScreen
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val router: Router,
    private val appScreens: AppScreensRepository,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(appScreens.usersScreen())
    }

    fun backPressed() {
        router.exit()
    }
}