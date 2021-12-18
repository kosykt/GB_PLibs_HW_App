package com.example.gb_plibs_hw_app.data.repository.userdetails.repository

import com.example.gb_plibs_hw_app.data.network.retrofit.model.NetworkUserDetailsModel
import io.reactivex.rxjava3.core.Single

interface RetrofitUserDetailsRepository {

    fun getUserDetails(reposUrl: String): Single<List<NetworkUserDetailsModel>>
}