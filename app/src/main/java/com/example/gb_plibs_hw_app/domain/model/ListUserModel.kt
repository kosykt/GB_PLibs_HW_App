package com.example.gb_plibs_hw_app.domain.model

import com.google.gson.annotations.Expose

data class ListUserModel(
    @Expose
    val login: String,

    @Expose
    val avatarUrl: String,
)