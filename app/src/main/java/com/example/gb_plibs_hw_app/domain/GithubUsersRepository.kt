package com.example.gb_plibs_hw_app.domain

import com.example.gb_plibs_hw_app.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubUsersRepository {

    fun getUsers(): Single<List<GithubUserModel>>
}