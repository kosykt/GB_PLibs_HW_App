package com.example.gb_plibs_hw_app.screens

import com.example.gb_plibs_hw_app.ui.login.LoginFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.example.gb_plibs_hw_app.ui.users.UsersFragment

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    fun loginScreen() = FragmentScreen {
        LoginFragment()
    }
}