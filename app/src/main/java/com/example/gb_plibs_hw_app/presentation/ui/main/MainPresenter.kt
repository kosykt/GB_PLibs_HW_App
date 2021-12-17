package com.example.gb_plibs_hw_app.presentation.ui.main

import com.example.gb_plibs_hw_app.presentation.AppScreensRepository
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class MainPresenter(
    private val router: Router,
    private val appScreensRepository: AppScreensRepository,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(appScreensRepository.usersScreen())
    }

    fun backPressed() {
        router.exit()
    }
}