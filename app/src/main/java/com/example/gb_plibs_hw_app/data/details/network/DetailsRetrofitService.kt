package com.example.gb_plibs_hw_app.data.details.network

import com.example.gb_plibs_hw_app.domain.details.model.DetailsModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface DetailsRetrofitService {

    @GET("mojombo/repos")
    fun getDetails(): Single<List<DetailsModel>>
}