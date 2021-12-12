package com.example.gb_plibs_hw_app.domain.details.usecases

import com.example.gb_plibs_hw_app.domain.details.model.DetailsModel
import com.example.gb_plibs_hw_app.domain.details.repository.GithubDetailsRepository
import io.reactivex.rxjava3.core.Single

class GetGithubUserDetailsUseCase(private val repository: GithubDetailsRepository) {

    fun execute(): Single<List<DetailsModel>> = repository.getDetailsList()
}