package com.example.gb_plibs_hw_app.presentation.ui.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.example.gb_plibs_hw_app.presentation.AppScreensRepositoryImpl

class MainPresenter(
    private val router: Router
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(AppScreensRepositoryImpl.usersScreen())
    }

    fun backPressed() {
        router.exit()
    }
}