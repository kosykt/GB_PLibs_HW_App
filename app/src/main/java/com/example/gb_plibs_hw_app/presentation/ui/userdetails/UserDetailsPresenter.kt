package com.example.gb_plibs_hw_app.presentation.ui.userdetails

import android.util.Log
import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import com.example.gb_plibs_hw_app.domain.userdetails.usecases.GetGithubUserDetailsUseCase
import com.example.gb_plibs_hw_app.domain.users.model.UsersListModel
import com.example.gb_plibs_hw_app.presentation.AppScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserDetailsPresenter(
    private val router: Router,
    private val usersList: UsersListModel,
    userDetailsRepository: GithubUserDetailsRepository
): MvpPresenter<UserDetailsView>() {

    private val getGithubUserDetailsUseCase =
        GetGithubUserDetailsUseCase(userDetailsRepository = userDetailsRepository)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        getGithubUserDetailsUseCase.execute(usersList.reposUrl)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { details ->
                    viewState.showUserRepos(details)
                    Log.d("Retrofit", "Успех $details")
                }, { e ->
                    Log.e("Retrofit", "Ошибка", e)
                }
            )
    }

    fun onRepoClicked(userDetailsModel: UserDetailsModel){
        router.navigateTo(AppScreens.repoDetailsScreen(userDetailsModel = userDetailsModel))
    }

    fun backPressed() {
        router.exit()
    }
}