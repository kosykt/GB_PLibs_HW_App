package com.example.gb_plibs_hw_app.ui.login

import moxy.MvpPresenter

class LoginPresenter(): MvpPresenter<LoginView>() {

    fun setLogin(login: String){
        viewState.setLoginTo(param = login)
    }
}