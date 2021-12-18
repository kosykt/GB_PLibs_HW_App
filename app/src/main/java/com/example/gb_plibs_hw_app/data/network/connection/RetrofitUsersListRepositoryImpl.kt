package com.example.gb_plibs_hw_app.data.network.connection

import com.example.gb_plibs_hw_app.data.network.retrofit.RetrofitService
import com.example.gb_plibs_hw_app.data.network.retrofit.model.NetworkUsersModel
import com.example.gb_plibs_hw_app.data.repository.users.repository.RetrofitUsersListRepository
import io.reactivex.rxjava3.core.Single

class RetrofitUsersListRepositoryImpl(private val retrofitService: RetrofitService) :
    RetrofitUsersListRepository {

    override fun getUsersList(): Single<List<NetworkUsersModel>> {
        return retrofitService.getUsers()
    }
}