package com.example.gb_plibs_hw_app.domain

import com.example.gb_plibs_hw_app.model.GithubUserModel

class GithubUsersRepository {

    private val users = listOf(
        GithubUserModel("user1"),
        GithubUserModel("user2"),
        GithubUserModel("user3"),
        GithubUserModel("user4"),
        GithubUserModel("user5"),
        GithubUserModel("user6"),
    )

    fun getUsers(): List<GithubUserModel> {
        return users
    }
}