package com.example.gb_plibs_hw_app.data.repository.users.repository

import com.example.gb_plibs_hw_app.data.network.retrofit.model.NetworkUsersModel
import io.reactivex.rxjava3.core.Single

interface RetrofitUsersListRepository {

    fun getUsersList(): Single<List<NetworkUsersModel>>
}