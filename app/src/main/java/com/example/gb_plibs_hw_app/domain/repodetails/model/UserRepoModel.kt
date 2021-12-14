package com.example.gb_plibs_hw_app.domain.repodetails.model

import java.io.Serializable

data class UserRepoModel(
    val id: String,
    val forksCount: Int
) : Serializable