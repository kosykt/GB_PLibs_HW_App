package com.example.gb_plibs_hw_app.data.repository.userdetails

import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import io.reactivex.rxjava3.core.Single

class GithubUserDetailsRepositoryImpl(
    private val retrofitService: RetrofitService
) : GithubUserDetailsRepository {

    override fun getDetailsList(reposUrl: String): Single<List<UserDetailsModel>> {

        return retrofitService.getDetails(url = reposUrl)
            .flatMap { listNetworkModel ->
                Single.fromCallable {
                    val returnedList = listNetworkModel.map { networkModel ->
                        UserDetailsModel(name = networkModel.name, url = networkModel.url)
                    }
                    returnedList
                }
            }
    }
}