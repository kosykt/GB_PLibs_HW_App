package com.example.gb_plibs_hw_app.domain.usecases

import com.example.gb_plibs_hw_app.domain.model.ListUserModel
import com.example.gb_plibs_hw_app.domain.repository.GithubUsersRepository
import io.reactivex.rxjava3.core.Single

class GetGithubUsersListUseCase(private val repository: GithubUsersRepository) {

    fun execute(): Single<List<ListUserModel>> = repository.getUsersList()
}