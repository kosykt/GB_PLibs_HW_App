package com.example.gb_plibs_hw_app.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.example.gb_plibs_hw_app.ui.users.UsersFragment

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }
}