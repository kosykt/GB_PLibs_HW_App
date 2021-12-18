package com.example.gb_plibs_hw_app.data.repository.userdetails

import com.example.gb_plibs_hw_app.data.repository.networkToDomainUserDetailsModel
import com.example.gb_plibs_hw_app.data.repository.roomToDomainUserDetailsModel
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RetrofitUserDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RoomCacheUserDetailsRepository
import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import io.reactivex.rxjava3.core.Single

class GithubUserDetailsRepositoryImpl(
    private val roomCacheUserDetails: RoomCacheUserDetailsRepository,
    private val retrofitUserDetailsRepository: RetrofitUserDetailsRepository
) : GithubUserDetailsRepository {

    override fun getNetworkDetailsList(reposUrl: String): Single<List<DomainUserDetailsModel>> {
        return retrofitUserDetailsRepository.getUserDetails(reposUrl)
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