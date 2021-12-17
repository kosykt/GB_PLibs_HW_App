package com.example.gb_plibs_hw_app.presentation.ui.repodetails

import android.util.Log
import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.domain.repodetails.repository.GithubRepoRepository
import com.example.gb_plibs_hw_app.domain.repodetails.usecases.GetGithubRepoUseCase
import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class RepoDetailsPresenter(
    private val router: Router,
    private val domainUserDetailsModel: DomainUserDetailsModel,
    private val networkStatus: NetworkStatus,
    githubRepoRepository: GithubRepoRepository
) : MvpPresenter<RepoDetailsView>() {

    private val githubRepoUseCase =
        GetGithubRepoUseCase(repoRepository = githubRepoRepository)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        githubRepoUseCase.execute(
            repoUrl = domainUserDetailsModel.url,
            repoId = domainUserDetailsModel.id,
            network = networkStatus.isOnline()
        )
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