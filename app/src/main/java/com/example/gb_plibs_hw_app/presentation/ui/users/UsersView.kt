package com.example.gb_plibs_hw_app.presentation.ui.users

import com.example.gb_plibs_hw_app.domain.users.model.UsersListModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface UsersView : MvpView {

    @AddToEndSingle
    fun updateList(usersLists: List<UsersListModel>)

    @AddToEndSingle
    fun showLoading()

    @AddToEndSingle
    fun hideLoading()
}