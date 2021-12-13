package com.example.gb_plibs_hw_app.domain.users.usecases

import com.example.gb_plibs_hw_app.domain.users.model.UsersListModel
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersListRepository
import io.reactivex.rxjava3.core.Single

class GetGithubUsersListUseCase(private val usersListRepository: GithubUsersListRepository) {

    fun execute(): Single<List<UsersListModel>> = usersListRepository.getUsersList()
}