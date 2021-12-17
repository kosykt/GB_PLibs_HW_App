package com.example.gb_plibs_hw_app.presentation.ui.repodetails

import com.example.gb_plibs_hw_app.domain.repodetails.model.UserRepoModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface RepoDetailsView: MvpView {

    @AddToEndSingle
    fun showRepoDetails(userRepoModel: UserRepoModel)
}