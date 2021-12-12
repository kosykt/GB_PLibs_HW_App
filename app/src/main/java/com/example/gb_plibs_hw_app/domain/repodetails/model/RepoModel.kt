package com.example.gb_plibs_hw_app.domain.repodetails.model

import com.google.gson.annotations.Expose
import java.io.Serializable

data class RepoModel(

    @Expose
    val forksCount: Int
) : Serializable