package com.example.gb_plibs_hw_app.presentation.ui.details

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface DetailsView: MvpView {

    @AddToEndSingle
    fun showDetails()
}