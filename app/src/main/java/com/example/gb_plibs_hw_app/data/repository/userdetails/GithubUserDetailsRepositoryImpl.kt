package com.example.gb_plibs_hw_app.data.repository.userdetails

import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.db.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.model.RoomUserDetailsModel
import com.example.gb_plibs_hw_app.data.network.RetrofitService
import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import com.example.gb_plibs_hw_app.domain.userdetails.repository.GithubUserDetailsRepository
import io.reactivex.rxjava3.core.Single

class GithubUserDetailsRepositoryImpl(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val db: AppDatabase
) : GithubUserDetailsRepository {

    override fun getDetailsList(reposUrl: String): Single<List<UserDetailsModel>> {

        return if (networkStatus.isOnline()) {
            retrofitService.getDetails(url = reposUrl)
                .flatMap { listNetworkModel ->
                    Single.fromCallable {
                        val roomUserDetails = listNetworkModel.map { networkModel ->
                            RoomUserDetailsModel(
                                id = networkModel.id,
                                name = networkModel.name,
                                url = networkModel.url,
                                userId = networkModel.owner.id
                            )
                        }
                        db.userDetailsDao.insert(roomUserDetails)

                        val returnedList = listNetworkModel.map { networkModel ->
                            UserDetailsModel(
                                id = networkModel.id,
                                name = networkModel.name,
                                url = networkModel.url,
                                userId = networkModel.owner.id
                            )
                        }
                        returnedList
                    }
                }
        } else {
            Single.fromCallable {
                db.userDetailsDao.getAll().map { networkModel ->
                    UserDetailsModel(
                        id = networkModel.id,
                        name = networkModel.name,
                        url = networkModel.url,
                        userId = networkModel.userId
                    )
                }
            }
        }
    }
}