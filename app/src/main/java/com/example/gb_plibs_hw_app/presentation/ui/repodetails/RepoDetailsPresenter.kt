package com.example.gb_plibs_hw_app.presentation.ui.repodetails

import com.example.gb_plibs_hw_app.presentation.AppScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class RepoDetailsPresenter(
    private val router: Router
): MvpPresenter<RepoDetailsView>() {


    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}