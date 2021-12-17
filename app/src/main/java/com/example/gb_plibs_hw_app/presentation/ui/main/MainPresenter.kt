package com.example.gb_plibs_hw_app.presentation.ui.main

import com.example.gb_plibs_hw_app.presentation.navigation.AppScreensRepository
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var appScreensRepository: AppScreensRepository

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(appScreensRepository.usersScreen())
    }

    fun backPressed() {
        router.exit()
    }
}