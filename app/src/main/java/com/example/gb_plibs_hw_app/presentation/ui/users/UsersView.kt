package com.example.gb_plibs_hw_app.presentation.ui.users

import com.example.gb_plibs_hw_app.domain.users.model.UserModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface UsersView : MvpView {

    @AddToEndSingle
    fun updateList(users: List<UserModel>)

    @AddToEndSingle
    fun showLoading()

    @AddToEndSingle
    fun hideLoading()
}