package com.example.gb_plibs_hw_app.domain.details.repository

import com.example.gb_plibs_hw_app.domain.details.model.DetailsModel
import io.reactivex.rxjava3.core.Single

interface GithubDetailsRepository {

    fun getDetailsList(reposUrl: String): Single<List<DetailsModel>>
}