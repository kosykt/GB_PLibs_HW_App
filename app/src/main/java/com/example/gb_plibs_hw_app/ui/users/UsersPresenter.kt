package com.example.gb_plibs_hw_app.ui.users

import android.util.Log
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.example.gb_plibs_hw_app.domain.GithubUsersRepository
import com.example.gb_plibs_hw_app.model.GithubUserModel
import com.example.gb_plibs_hw_app.remote.ApiHolder
import com.example.gb_plibs_hw_app.screens.AppScreens
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository,
) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        usersRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.showLoading() }
            .subscribe(
                { users ->
                    viewState.updateList(users)
                    viewState.hideLoading()
                }, { e ->
                    Log.e("Retrofit", "Ошибка при получении пользователей", e)
                    viewState.hideLoading()
                }
            )
    }

    fun onUserClicked(userModel: GithubUserModel) {
        router.navigateTo(AppScreens.loginScreen(userModel.login))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}