package com.example.gb_plibs_hw_app.domain.users.repository

import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import io.reactivex.rxjava3.core.Single

interface GithubUsersListRepository {

    fun getUsersList(): Single<List<DomainUsersModel>>
}