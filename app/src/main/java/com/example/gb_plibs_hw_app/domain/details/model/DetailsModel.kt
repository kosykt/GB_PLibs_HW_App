package com.example.gb_plibs_hw_app.domain.details.model

import com.google.gson.annotations.Expose
import java.io.Serializable

data class DetailsModel(

    @Expose
    val name: String,

    @Expose
    val url: String
): Serializable