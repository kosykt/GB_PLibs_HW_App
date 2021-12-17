package com.example.gb_plibs_hw_app.presentation.ui.users

import android.util.Log
import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import com.example.gb_plibs_hw_app.domain.users.usecases.GetGithubUsersListUseCase
import com.example.gb_plibs_hw_app.presentation.navigation.AppScreensRepository
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UsersPresenter : MvpPresenter<UsersView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var appScreensRepository: AppScreensRepository

    @Inject
    lateinit var networkStatus: NetworkStatus

    @Inject
    lateinit var getGithubUsersListUseCase: GetGithubUsersListUseCase

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        getGithubUsersListUseCase.execute(network = networkStatus.isOnline())
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

    fun onUserClicked(domainUsersModel: DomainUsersModel) {
        router.navigateTo(appScreensRepository.userDetailsScreen(usersModel = domainUsersModel))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}