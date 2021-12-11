package com.example.gb_plibs_hw_app.domain.users.repository

import com.example.gb_plibs_hw_app.domain.users.model.ListUserModel
import io.reactivex.rxjava3.core.Single

interface GithubUsersRepository {

    fun getUsersList(): Single<List<ListUserModel>>
}