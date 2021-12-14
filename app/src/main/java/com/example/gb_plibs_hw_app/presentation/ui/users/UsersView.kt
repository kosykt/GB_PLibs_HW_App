package com.example.gb_plibs_hw_app.presentation.ui.users

import com.example.gb_plibs_hw_app.domain.users.model.UsersModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface UsersView : MvpView {

    @AddToEndSingle
    fun updateList(usersLists: List<UsersModel>)

    @AddToEndSingle
    fun showLoading()

    @AddToEndSingle
    fun hideLoading()
}