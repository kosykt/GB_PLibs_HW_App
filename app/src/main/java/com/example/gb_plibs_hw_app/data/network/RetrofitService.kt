package com.example.gb_plibs_hw_app.data.network

import com.example.gb_plibs_hw_app.data.repository.repodetails.NetworkUserRepoModel
import com.example.gb_plibs_hw_app.data.repository.userdetails.NetworkUserDetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.UsersModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitService {

    @GET("/users")
    fun getUsers(): Single<List<UsersModel>>

    @GET
    fun getDetails(@Url url: String): Single<List<NetworkUserDetailsModel>>

    @GET
    fun getRepo(@Url url: String): Single<NetworkUserRepoModel>
}