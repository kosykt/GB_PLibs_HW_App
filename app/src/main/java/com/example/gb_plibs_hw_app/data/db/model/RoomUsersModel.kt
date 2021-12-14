package com.example.gb_plibs_hw_app.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomUsersModel(

    @PrimaryKey
    val id: String,
    val login: String,
    val avatarUrl: String,
    val reposUrl: String
)