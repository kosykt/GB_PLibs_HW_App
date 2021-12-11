package com.example.gb_plibs_hw_app.presentation

import com.example.gb_plibs_hw_app.presentation.ui.details.DetailsFragment
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    fun detailsScreen(user: String) = FragmentScreen{
        DetailsFragment.newInstance(user = user)
    }
}