package com.example.gb_plibs_hw_app.presentation.ui.details

import com.example.gb_plibs_hw_app.domain.details.model.DetailsModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface DetailsView: MvpView {

    @AddToEndSingle
    fun showDetails()

    @AddToEndSingle
    fun show(repos: List<DetailsModel>)
}