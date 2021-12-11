package com.example.gb_plibs_hw_app.data.nerwork

import com.example.gb_plibs_hw_app.domain.model.ListUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("/users")
    fun getUsers(): Single<List<ListUserModel>>
}