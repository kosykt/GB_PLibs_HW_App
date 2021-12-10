package com.example.gb_plibs_hw_app.presentation.ui.login

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface LoginView : MvpView{

    @AddToEndSingle
    fun setLoginTo(param: String)
}