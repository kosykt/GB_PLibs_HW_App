package com.example.gb_plibs_hw_app.presentation

import com.example.gb_plibs_hw_app.presentation.ui.login.LoginFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.example.gb_plibs_hw_app.presentation.ui.users.UsersFragment

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }

    fun loginScreen(login: String) = FragmentScreen {
        LoginFragment(login = login)
    }
}