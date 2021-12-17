package com.example.gb_plibs_hw_app.presentation.navigation

import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface AppScreensRepository {

    fun usersScreen(): FragmentScreen
    fun userDetailsScreen(usersModel: DomainUsersModel): FragmentScreen
    fun repoDetailsScreen(userDetailsModel: DomainUserDetailsModel): FragmentScreen
}