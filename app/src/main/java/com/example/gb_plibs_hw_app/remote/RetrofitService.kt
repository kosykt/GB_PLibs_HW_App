package com.example.gb_plibs_hw_app.remote

import com.example.gb_plibs_hw_app.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("/users")
    fun getUsers(): Single<List<GithubUserModel>>
}