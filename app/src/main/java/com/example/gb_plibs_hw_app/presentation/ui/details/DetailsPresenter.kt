package com.example.gb_plibs_hw_app.presentation.ui.details

import android.util.Log
import com.example.gb_plibs_hw_app.domain.details.model.DetailsModel
import com.example.gb_plibs_hw_app.domain.details.repository.GithubDetailsRepository
import com.example.gb_plibs_hw_app.domain.details.usecases.GetGithubUserDetailsUseCase
import com.example.gb_plibs_hw_app.domain.users.model.UserModel
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class DetailsPresenter(
    private val router: Router,
    private val user: UserModel,
    detailsRepository: GithubDetailsRepository
): MvpPresenter<DetailsView>() {

    private val getGithubUserDetailsUseCase =
        GetGithubUserDetailsUseCase(repository = detailsRepository)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        getGithubUserDetailsUseCase.execute(user.reposUrl)
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

    fun backPressed() {
        router.exit()
    }
}