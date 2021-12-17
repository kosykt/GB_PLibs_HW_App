package com.example.gb_plibs_hw_app.domain.users.repository

import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import io.reactivex.rxjava3.core.Single

interface GithubUsersListRepository {

    fun getNetworkUsersList(): Single<List<DomainUsersModel>>

    fun getDbUsersList(): Single<List<DomainUsersModel>>
}