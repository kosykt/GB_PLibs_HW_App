package com.example.gb_plibs_hw_app.presentation.ui.details

import com.example.gb_plibs_hw_app.domain.users.model.UserModel
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class DetailsPresenter(
    private val router: Router,
    private val user: UserModel
): MvpPresenter<DetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {

    }

    fun backPressed() {
        router.exit()
    }
}