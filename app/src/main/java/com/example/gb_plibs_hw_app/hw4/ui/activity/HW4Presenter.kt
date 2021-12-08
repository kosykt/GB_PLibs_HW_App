package com.example.gb_plibs_hw_app.hw4.ui.activity

import com.example.gb_plibs_hw_app.screens.AppScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class HW4Presenter(
    private val router: Router
) : MvpPresenter<HW4View>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(AppScreens.hw4Screen())
    }

    fun backPressed() {
        router.exit()
    }
}