package com.example.gb_plibs_hw_app.presentation

import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.UsersModel
import com.example.gb_plibs_hw_app.presentation.ui.userdetails.UserDetailsFragment
import com.example.gb_plibs_hw_app.presentation.ui.repodetails.RepoDetailsFragment
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface AppScreensRepository{

    fun usersScreen(): FragmentScreen
    fun userDetailsScreen(usersModel: UsersModel): FragmentScreen
    fun repoDetailsScreen(userDetailsModel: UserDetailsModel): FragmentScreen
}

class AppScreensRepositoryImpl: AppScreensRepository {

    override fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    override fun userDetailsScreen(usersModel: UsersModel) = FragmentScreen{
        UserDetailsFragment.newInstance(usersModel = usersModel)
    }

    override fun repoDetailsScreen(userDetailsModel: UserDetailsModel) = FragmentScreen{
        RepoDetailsFragment.newInstance(repo = userDetailsModel)
    }
}