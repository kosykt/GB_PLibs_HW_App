package com.example.gb_plibs_hw_app.di.containers

import com.example.gb_plibs_hw_app.di.components.DetailsSubcomponent

interface DetailsContainer {

    fun initDetailsSubcomponent(): DetailsSubcomponent

    fun destroyDetailsSubcomponent()
}