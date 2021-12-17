package com.example.gb_plibs_hw_app.presentation.ui.userdetails

import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface UserDetailsView: MvpView {

    @AddToEndSingle
    fun showUserRepos(repos: List<DomainUserDetailsModel>)
}