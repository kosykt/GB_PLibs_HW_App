package com.example.gb_plibs_hw_app.presentation

import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.UsersListModel
import com.example.gb_plibs_hw_app.presentation.ui.userdetails.UserDetailsFragment
import com.example.gb_plibs_hw_app.presentation.ui.repodetails.RepoDetailsFragment
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    fun userDetailsScreen(usersListModel: UsersListModel) = FragmentScreen{
        UserDetailsFragment.newInstance(usersList = usersListModel)
    }

    fun repoDetailsScreen(userDetailsModel: UserDetailsModel) = FragmentScreen{
        RepoDetailsFragment.newInstance(repo = userDetailsModel)
    }
}