package com.example.gb_plibs_hw_app.di.containers

import com.example.gb_plibs_hw_app.di.components.RepoSubcomponent

interface RepoContainer {

    fun initRepoSubcomponent(): RepoSubcomponent

    fun destroyRepoSubcomponent()
}