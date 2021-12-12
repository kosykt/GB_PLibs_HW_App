package com.example.gb_plibs_hw_app.domain.users.usecases

import com.example.gb_plibs_hw_app.domain.users.model.UserModel
import com.example.gb_plibs_hw_app.domain.users.repository.GithubUsersRepository
import io.reactivex.rxjava3.core.Single

class GetGithubUsersListUseCase(private val repository: GithubUsersRepository) {

    fun execute(): Single<List<UserModel>> = repository.getUsersList()
}