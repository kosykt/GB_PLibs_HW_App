package com.example.gb_plibs_hw_app.data.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = RoomUsersModel::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RoomUserDetailsModel(

    @PrimaryKey
    val id: String,
    val name: String,
    val url: String,
    val userId: String
)