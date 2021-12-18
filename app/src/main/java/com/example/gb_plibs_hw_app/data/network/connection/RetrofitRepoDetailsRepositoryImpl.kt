package com.example.gb_plibs_hw_app.data.network.connection

import com.example.gb_plibs_hw_app.data.network.retrofit.RetrofitService
import com.example.gb_plibs_hw_app.data.network.retrofit.model.NetworkUserRepoModel
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RetrofitRepoDetailsRepository
import io.reactivex.rxjava3.core.Single

class RetrofitRepoDetailsRepositoryImpl(private val retrofitService: RetrofitService) :
    RetrofitRepoDetailsRepository {

    override fun getRepoDetails(repoUrl: String): Single<NetworkUserRepoModel> {
        return retrofitService.getRepo(repoUrl)
    }

}