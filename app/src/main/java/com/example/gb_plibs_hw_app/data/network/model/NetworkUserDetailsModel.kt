package com.example.gb_plibs_hw_app.data.network.model

import com.google.gson.annotations.Expose

data class NetworkUserDetailsModel(

    @Expose
    val id: String,

    @Expose
    val name: String,

    @Expose
    val url: String,

    @Expose
    val owner: NetworkUserOwner,
)

data class NetworkUserOwner(
    @Expose
    val id: String,
)
