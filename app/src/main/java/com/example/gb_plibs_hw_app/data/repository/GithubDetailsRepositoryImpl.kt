package com.example.gb_plibs_hw_app.data.repository

import com.example.gb_plibs_hw_app.data.nerwork.RetrofitService
import com.example.gb_plibs_hw_app.domain.details.model.DetailsModel
import com.example.gb_plibs_hw_app.domain.details.repository.GithubDetailsRepository
import io.reactivex.rxjava3.core.Single

class GithubDetailsRepositoryImpl(
    private val retrofitService: RetrofitService
) : GithubDetailsRepository {

    override fun getDetailsList(reposUrl: String): Single<List<DetailsModel>> {
        return retrofitService.getDetails(url = reposUrl)
    }
}