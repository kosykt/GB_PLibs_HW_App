package com.example.gb_plibs_hw_app.data.repository

import com.example.gb_plibs_hw_app.data.db.model.RoomUserDetailsModel
import com.example.gb_plibs_hw_app.data.db.model.RoomUserRepoModel
import com.example.gb_plibs_hw_app.data.db.model.RoomUsersModel
import com.example.gb_plibs_hw_app.data.network.model.NetworkUserDetailsModel
import com.example.gb_plibs_hw_app.data.network.model.NetworkUserRepoModel
import com.example.gb_plibs_hw_app.data.network.model.NetworkUsersModel
import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel

fun NetworkUserRepoModel.toDomainUserRepoModel() = DomainUserRepoModel(this.id, this.forksCount)

fun RoomUserRepoModel.toDomainUserRepoModel() = DomainUserRepoModel(this.id, this.forksCount)

fun NetworkUserRepoModel.toRoomUserRepoModel() = RoomUserRepoModel(this.id, this.forksCount)

fun NetworkUserDetailsModel.networkToDomainUserDetailsModel() =
    DomainUserDetailsModel(id = this.id, name = this.name, url = this.url, userId = this.owner.id)

fun List<NetworkUserDetailsModel>.networkToDomainUserDetailsModel() =
    this.map { it.networkToDomainUserDetailsModel() }

fun NetworkUserDetailsModel.networkToRoomUserDetailsModel() =
    RoomUserDetailsModel(id = this.id, name = this.name, url = this.url, userId = this.owner.id)

fun List<NetworkUserDetailsModel>.networkToRoomUserDetailsModel() =
    this.map { it.networkToRoomUserDetailsModel() }

fun RoomUserDetailsModel.roomToDomainUserDetailsModel() =
    DomainUserDetailsModel(id = this.id, name = this.name, url = this.url, userId = this.userId)

fun List<RoomUserDetailsModel>.roomToDomainUserDetailsModel() =
    this.map { it.roomToDomainUserDetailsModel() }

fun NetworkUsersModel.networkToDomainUsersModel() = DomainUsersModel(
    id = this.id, login = this.login, avatarUrl = this.avatarUrl, reposUrl = this.reposUrl
)

fun List<NetworkUsersModel>.networkToDomainUsersModel() =
    this.map { it.networkToDomainUsersModel() }

fun NetworkUsersModel.networkToRoomUsersModel() = RoomUsersModel(
    id = this.id, login = this.login, avatarUrl = this.avatarUrl, reposUrl = this.reposUrl
)

fun List<NetworkUsersModel>.networkToRoomUsersModel() =
    this.map { it.networkToRoomUsersModel() }

fun RoomUsersModel.roomToDomainUsersModel() = DomainUsersModel(
    id = this.id, login = this.login, avatarUrl = this.avatarUrl, reposUrl = this.reposUrl
)

fun List<RoomUsersModel>.roomToDomainUsersModel() =
    this.map { it.roomToDomainUsersModel() }