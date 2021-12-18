package com.example.gb_plibs_hw_app.data.repository.repodetails.repository

import com.example.gb_plibs_hw_app.data.network.retrofit.model.NetworkUserRepoModel
import io.reactivex.rxjava3.core.Single

interface RetrofitRepoDetailsRepository {

    fun getRepoDetails(repoUrl: String): Single<NetworkUserRepoModel>

}