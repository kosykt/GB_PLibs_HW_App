package com.example.gb_plibs_hw_app.presentation.ui.users

import android.util.Log
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import com.example.gb_plibs_hw_app.domain.users.model.UsersModel
import com.example.gb_plibs_hw_app.domain.users.usecases.GetGithubUsersListUseCase
import com.example.gb_plibs_hw_app.presentation.AppScreensRepository
import com.example.gb_plibs_hw_app.presentation.AppScreensRepositoryImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UsersPresenter() : MvpPresenter<UsersView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var appScreensRepository: AppScreensRepository

    @Inject
    lateinit var getGithubUsersListUseCase: GetGithubUsersListUseCase

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

    fun onUserClicked(usersModel: UsersModel) {
        router.navigateTo(appScreensRepository.userDetailsScreen(usersModel = usersModel))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}