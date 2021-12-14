package com.example.gb_plibs_hw_app.domain.users.model

import java.io.Serializable

data class UsersModel(

    val login: String,
    val avatarUrl: String,
    val reposUrl: String
): Serializable