package com.example.gb_plibs_hw_app.data.repository.userdetails

import com.example.gb_plibs_hw_app.data.db.RoomCacheUserDetails
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.networkToDomainUserDetailsModel
import com.example.gb_plibs_hw_app.data.repository.roomToDomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import io.reactivex.rxjava3.core.Single

class GithubUserDetailsRepositoryImpl(
    private val roomCacheUserDetails: RoomCacheUserDetails,
    private val retrofitService: RetrofitService
) : GithubUserDetailsRepository {

    override fun getNetworkDetailsList(reposUrl: String): Single<List<DomainUserDetailsModel>> {
        return retrofitService.getDetails(url = reposUrl)
            .doOnSuccess {
                roomCacheUserDetails.insertUserDetails(it)
            }
            .map {
                it.networkToDomainUserDetailsModel()
            }
    }

    override fun getDbDetailsList(userId: String): Single<List<DomainUserDetailsModel>> {
        return roomCacheUserDetails.getUserDetailsById(userId)
            .map { it.roomToDomainUserDetailsModel() }
    }
}