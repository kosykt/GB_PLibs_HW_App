package com.example.gb_plibs_hw_app.presentation

import com.example.gb_plibs_hw_app.domain.details.model.DetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.UserModel
import com.example.gb_plibs_hw_app.presentation.ui.details.DetailsFragment
import com.example.gb_plibs_hw_app.presentation.ui.repodetails.RepoDetailsFragment
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    fun detailsScreen(userModel: UserModel) = FragmentScreen{
        DetailsFragment.newInstance(user = userModel)
    }

    fun repoDetailsScreen(detailsModel: DetailsModel) = FragmentScreen{
        RepoDetailsFragment.newInstance(repo = detailsModel)
    }
}