package com.example.gb_plibs_hw_app.hw4.ui.fragment

import android.graphics.Bitmap
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ConvertPictureView : MvpView {

    @AddToEndSingle
    fun showImageJPG(bitmap: Bitmap)

    @AddToEndSingle
    fun showImagePNG(bitmap: Bitmap)

    @AddToEndSingle
    fun showImagePNGLabel()

    @AddToEndSingle
    fun showError(errorMessage: String?)
}