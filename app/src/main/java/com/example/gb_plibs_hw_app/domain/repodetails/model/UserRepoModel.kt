package com.example.gb_plibs_hw_app.domain.repodetails.model

import com.google.gson.annotations.Expose
import java.io.Serializable

data class UserRepoModel(

    @Expose
    val forksCount: Int
) : Serializable