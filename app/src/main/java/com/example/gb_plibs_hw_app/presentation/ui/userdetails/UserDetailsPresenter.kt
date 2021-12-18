package com.example.gb_plibs_hw_app.presentation.ui.userdetails

import android.util.Log
import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.di.containers.DetailsContainer
import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.usecases.GetGithubUserDetailsUseCase
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import com.example.gb_plibs_hw_app.presentation.navigation.AppScreensRepository
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserDetailsPresenter @AssistedInject constructor(
    private val router: Router,
    private val appScreensRepository: AppScreensRepository,
    private val networkStatus: NetworkStatus,
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase,
    private val detailsContainer: DetailsContainer,
    @Assisted private val domainUsersModel: DomainUsersModel
) : MvpPresenter<UserDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    override fun onDestroy() {
        detailsContainer.destroyDetailsSubcomponent()
        super.onDestroy()
    }

    private fun loadData() {
        getGithubUserDetailsUseCase.execute(
            userReposUrl = domainUsersModel.reposUrl,
            userId = domainUsersModel.id,
            network = networkStatus.isOnline()
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

    fun onRepoClicked(domainUserDetailsModel: DomainUserDetailsModel) {
        router.navigateTo(appScreensRepository.repoDetailsScreen(userDetailsModel = domainUserDetailsModel))
    }

    fun backPressed() {
        router.exit()
    }
}

@AssistedFactory
interface UserDetailsPresenterFactory {
    fun presenter(usersModel: DomainUsersModel): UserDetailsPresenter
}