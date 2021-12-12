package com.example.gb_plibs_hw_app.data.details.repository

import com.example.gb_plibs_hw_app.data.details.network.DetailsRetrofitService
import com.example.gb_plibs_hw_app.domain.details.model.DetailsModel
import com.example.gb_plibs_hw_app.domain.details.repository.GithubDetailsRepository
import io.reactivex.rxjava3.core.Single

class GithubDetailsRepositoryImpl(
    private val retrofitService: DetailsRetrofitService
) : GithubDetailsRepository {

    override fun getDetailsList(): Single<List<DetailsModel>> {
        return retrofitService.getDetails()
    }
}