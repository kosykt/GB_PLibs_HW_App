package com.example.gb_plibs_hw_app.data.network.connection

import com.example.gb_plibs_hw_app.data.network.retrofit.RetrofitService
import com.example.gb_plibs_hw_app.data.network.retrofit.model.NetworkUserDetailsModel
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RetrofitUserDetailsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RetrofitUserDetailsRepositoryImpl @Inject constructor(private val retrofitService: RetrofitService) :
    RetrofitUserDetailsRepository {

    override fun getUserDetails(reposUrl: String): Single<List<NetworkUserDetailsModel>> {
        return retrofitService.getDetails(reposUrl)
    }

}