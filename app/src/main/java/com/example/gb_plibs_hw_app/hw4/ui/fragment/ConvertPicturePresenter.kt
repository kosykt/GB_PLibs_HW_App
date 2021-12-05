package com.example.gb_plibs_hw_app.hw4.ui.fragment

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class ConvertPicturePresenter(
    private val router: Router
): MvpPresenter<ConvertPictureView>() {

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}