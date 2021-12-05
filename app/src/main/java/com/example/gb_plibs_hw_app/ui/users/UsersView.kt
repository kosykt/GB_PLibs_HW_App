package com.example.gb_plibs_hw_app.ui.users

import com.example.gb_plibs_hw_app.model.GithubUserModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface UsersView : MvpView {

    @AddToEndSingle
    fun updateList(users: List<GithubUserModel>)
}