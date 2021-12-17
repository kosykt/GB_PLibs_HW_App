package com.example.gb_plibs_hw_app.domain.users.model

import com.google.gson.annotations.Expose
import java.io.Serializable

data class UsersListModel(
    @Expose
    val login: String,

    @Expose
    val avatarUrl: String,

    @Expose
    val reposUrl: String
): Serializable