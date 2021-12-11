package com.example.gb_plibs_hw_app.presentation.ui.users

import android.util.Log
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersRepository
import com.example.gb_plibs_hw_app.domain.users.model.ListUserModel
import com.example.gb_plibs_hw_app.domain.users.usecases.GetGithubUsersListUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class UsersPresenter(
    private val router: Router,
    usersRepository: GithubUsersRepository
) : MvpPresenter<UsersView>() {

    private val getGithubUsersListUseCase =
        GetGithubUsersListUseCase(repository = usersRepository)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        getGithubUsersListUseCase.execute()
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

    fun onUserClicked(userModel: ListUserModel) {
//        router.navigateTo(AppScreens.loginScreen(login = userModel.login))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}