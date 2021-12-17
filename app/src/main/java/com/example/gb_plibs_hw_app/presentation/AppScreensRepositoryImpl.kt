package com.example.gb_plibs_hw_app.presentation

import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import com.example.gb_plibs_hw_app.presentation.ui.repodetails.RepoDetailsFragment
import com.example.gb_plibs_hw_app.presentation.ui.userdetails.UserDetailsFragment
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AppScreensRepositoryImpl : AppScreensRepository {

    override fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    override fun userDetailsScreen(usersModel: DomainUsersModel) = FragmentScreen {
        UserDetailsFragment.newInstance(domainUsersModel = usersModel)
    }

    override fun repoDetailsScreen(userDetailsModel: DomainUserDetailsModel) = FragmentScreen {
        RepoDetailsFragment.newInstance(repo = userDetailsModel)
    }
}