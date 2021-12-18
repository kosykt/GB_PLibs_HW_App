package com.example.gb_plibs_hw_app.di.containers

import com.example.gb_plibs_hw_app.di.components.UsersSubcomponent

interface UsersContainer {

    fun initUsersSubcomponent(): UsersSubcomponent

    fun destroyUsersSubcomponent()
}