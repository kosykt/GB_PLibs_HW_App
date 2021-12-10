package com.example.gb_plibs_hw_app.model

import com.google.gson.annotations.Expose

data class GithubUserModel(
    @Expose
    val login: String,

    @Expose
    val avatarUrl: String,
)