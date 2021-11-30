package com.example.gb_plibs_hw_app.ui.users

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.example.gb_plibs_hw_app.domain.GithubUsersRepository
import com.example.gb_plibs_hw_app.model.GithubUserModel
import com.example.gb_plibs_hw_app.screens.AppScreens
import com.example.gb_plibs_hw_app.ui.base.IListPresenter

class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository,
) : MvpPresenter<UsersView>() {

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()

        usersListPresenter.itemClickListener = {
            router.navigateTo(
                AppScreens.loginScreen(usersRepository.getUsers()[it.pos].login)
            )
        }
    }

    private fun loadData() {
        val users = usersRepository.getUsers()
        usersListPresenter.users.addAll(users)

        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    class UsersListPresenter : IListPresenter<UserItemView> {

        val users = mutableListOf<GithubUserModel>()

        override var itemClickListener: (UserItemView) -> Unit = { }

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }
}