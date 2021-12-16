package com.example.gb_plibs_hw_app.presentation.navigation

import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.UsersModel
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface AppScreensRepository{

    fun usersScreen(): FragmentScreen
    fun userDetailsScreen(usersModel: UsersModel): FragmentScreen
    fun repoDetailsScreen(userDetailsModel: UserDetailsModel): FragmentScreen
}