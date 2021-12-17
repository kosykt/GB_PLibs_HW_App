package com.example.gb_plibs_hw_app.data.network.model

import com.google.gson.annotations.Expose

data class NetworkUsersModel(

    @Expose
    val id: String,

    @Expose
    val login: String,

    @Expose
    val avatarUrl: String,

    @Expose
    val reposUrl: String
)
