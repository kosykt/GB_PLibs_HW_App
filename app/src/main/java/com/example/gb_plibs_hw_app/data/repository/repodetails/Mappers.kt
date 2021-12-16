package com.example.gb_plibs_hw_app.data.repository.repodetails

import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel
import com.example.gb_plibs_hw_app.data.network.model.NetworkUserRepoModel
import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel

fun NetworkUserRepoModel.toDomainUserRepoModel() = DomainUserRepoModel(this.id, this.forksCount)
fun RoomUserRepoModel.toDomainUserRepoModel() = DomainUserRepoModel(this.id, this.forksCount)

fun NetworkUserRepoModel.toRoomUserRepoModel() = RoomUserRepoModel(this.id, this.forksCount)