package com.example.gb_plibs_hw_app.hw4.ui.fragment

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ConvertPictureView: MvpView {

    @AddToEndSingle
    fun convertToPNG()
}