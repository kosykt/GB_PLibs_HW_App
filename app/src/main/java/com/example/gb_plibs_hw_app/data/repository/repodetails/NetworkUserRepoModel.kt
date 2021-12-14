package com.example.gb_plibs_hw_app.data.repository.repodetails

import com.google.gson.annotations.Expose
import java.io.Serializable

data class NetworkUserRepoModel(
    @Expose
    val id: String,
    @Expose
    val forksCount: Int
) : Serializable
