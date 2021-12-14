package com.example.gb_plibs_hw_app.data.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity()
data class RoomUserDetailsModel(

    @PrimaryKey
    val id: String,
    val name: String,
    val url: String
)