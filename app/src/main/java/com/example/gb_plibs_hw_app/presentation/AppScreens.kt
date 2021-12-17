package com.example.gb_plibs_hw_app.presentation

import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import com.example.gb_plibs_hw_app.presentation.ui.repodetails.RepoDetailsFragment
import com.example.gb_plibs_hw_app.presentation.ui.userdetails.UserDetailsFragment
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    fun userDetailsScreen(domainUsersModel: DomainUsersModel) = FragmentScreen {
        UserDetailsFragment.newInstance(domainUsersModel = domainUsersModel)
    }

    fun repoDetailsScreen(domainUserDetailsModel: DomainUserDetailsModel) = FragmentScreen {
        RepoDetailsFragment.newInstance(repo = domainUserDetailsModel)
    }
}