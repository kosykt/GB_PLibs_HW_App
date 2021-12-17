package com.example.gb_plibs_hw_app.domain.userdetails.model

import java.io.Serializable

data class DomainUserDetailsModel(

    val id: String,
    val name: String,
    val url: String,
    val userId: String
) : Serializable