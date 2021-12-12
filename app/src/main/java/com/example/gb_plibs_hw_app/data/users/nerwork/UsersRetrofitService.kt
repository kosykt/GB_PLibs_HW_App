package com.example.gb_plibs_hw_app.data.users.nerwork

import com.example.gb_plibs_hw_app.domain.users.model.UserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface UsersRetrofitService {

    @GET("/users")
    fun getUsers(): Single<List<UserModel>>
}