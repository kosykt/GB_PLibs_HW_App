package com.example.gb_plibs_hw_app.data.nerwork

import com.example.gb_plibs_hw_app.domain.details.model.DetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.UserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitService {

    @GET("/users")
    fun getUsers(): Single<List<UserModel>>


    @GET
    fun getDetails(@Url url: String): Single<List<DetailsModel>>}