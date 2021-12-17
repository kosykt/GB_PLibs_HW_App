package com.example.gb_plibs_hw_app.presentation.ui.repodetails

import android.util.Log
import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import com.example.gb_plibs_hw_app.domain.repodetails.usecases.GetGithubRepoUseCase
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class RepoDetailsPresenter(
    private val router: Router,
    private val userDetailsModel: UserDetailsModel,
    githubRepoRepository: GithubRepoRepository
): MvpPresenter<RepoDetailsView>() {

    private val githubRepoUseCase =
        GetGithubRepoUseCase(repository = githubRepoRepository)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        githubRepoUseCase.execute(repoUrl = userDetailsModel.url, repoId = userDetailsModel.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { details ->
                    viewState.showRepoDetails(details)
                    Log.d("Retrofit", "Успех $details")
                }, { e ->
                    Log.e("Retrofit", "Ошибка", e)
                }
            )
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}