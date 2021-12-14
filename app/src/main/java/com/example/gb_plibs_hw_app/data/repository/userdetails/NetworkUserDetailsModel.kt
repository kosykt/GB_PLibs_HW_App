package com.example.gb_plibs_hw_app.data.repository.userdetails

import com.google.gson.annotations.Expose
import java.io.Serializable

data class NetworkUserDetailsModel(
    @Expose
    val name: String,

    @Expose
    val url: String
): Serializable
