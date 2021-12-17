package com.example.gb_plibs_hw_app.data.repository.userdetails

import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.data.repository.networkToDomainUserDetailsModel
import com.example.gb_plibs_hw_app.data.repository.networkToRoomUserDetailsModel
import com.example.gb_plibs_hw_app.data.repository.roomToDomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import io.reactivex.rxjava3.core.Single

class GithubUserDetailsRepositoryImpl(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val db: AppDatabase
) : GithubUserDetailsRepository {

    override fun getDetailsList(
        reposUrl: String, userId: String
    ): Single<List<DomainUserDetailsModel>> {

        return when (networkStatus.isOnline()) {
            true -> retrofitService.getDetails(url = reposUrl)
                .doOnSuccess {
                    db.userDetailsDao.insert(it.networkToRoomUserDetailsModel())
                }
                .map {
                    it.networkToDomainUserDetailsModel()
                }
            false -> Single.fromCallable {
                db.userDetailsDao.getByUserId(userId = userId).roomToDomainUserDetailsModel()
            }
        }
    }
}