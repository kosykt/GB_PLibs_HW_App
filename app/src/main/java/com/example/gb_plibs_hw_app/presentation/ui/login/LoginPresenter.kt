package com.example.gb_plibs_hw_app.presentation.ui.login

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class LoginPresenter(
    private val router: Router,
    private val login: String
): MvpPresenter<LoginView>() {

    fun setLogin(){
        viewState.setLoginTo(param = login)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}