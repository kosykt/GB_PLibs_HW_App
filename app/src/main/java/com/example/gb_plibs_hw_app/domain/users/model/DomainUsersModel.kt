package com.example.gb_plibs_hw_app.domain.users.model

import java.io.Serializable

data class DomainUsersModel(

    val id: String,
    val login: String,
    val avatarUrl: String,
    val reposUrl: String
) : Serializable