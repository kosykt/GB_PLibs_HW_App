package com.example.gb_plibs_hw_app.domain.userdetails.model

import com.google.gson.annotations.Expose
import java.io.Serializable

data class UserDetailsModel(

    @Expose
    val name: String,

    @Expose
    val url: String
): Serializable