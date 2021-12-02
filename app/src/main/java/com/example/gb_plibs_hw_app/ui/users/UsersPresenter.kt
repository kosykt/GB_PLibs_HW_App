package com.example.gb_plibs_hw_app.ui.users

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.example.gb_plibs_hw_app.domain.GithubUsersRepository
import com.example.gb_plibs_hw_app.model.GithubUserModel
import com.example.gb_plibs_hw_app.screens.AppScreens

class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository,
) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        val users = usersRepository.getUsers()

        viewState.updateList(users)
    }

    fun onUserClicked(userModel: GithubUserModel) {
        router.navigateTo(AppScreens.loginScreen(userModel.login))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}