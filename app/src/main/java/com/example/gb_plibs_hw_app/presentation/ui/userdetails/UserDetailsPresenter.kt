package com.example.gb_plibs_hw_app.presentation.ui.userdetails

import android.util.Log
import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import com.example.gb_plibs_hw_app.domain.userdetails.usecases.GetGithubUserDetailsUseCase
import com.example.gb_plibs_hw_app.domain.users.model.UsersModel
import com.example.gb_plibs_hw_app.presentation.AppScreensRepository
import com.example.gb_plibs_hw_app.presentation.AppScreensRepositoryImpl
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UserDetailsPresenter(
    private val usersModel: UsersModel
) : MvpPresenter<UserDetailsView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var appScreensRepository: AppScreensRepository

    @Inject
    lateinit var getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        getGithubUserDetailsUseCase.execute(
            userReposUrl = usersModel.reposUrl,
            userId = usersModel.id
        )
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

    fun onRepoClicked(userDetailsModel: UserDetailsModel) {
        router.navigateTo(appScreensRepository.repoDetailsScreen(userDetailsModel = userDetailsModel))
    }

    fun backPressed() {
        router.exit()
    }
}