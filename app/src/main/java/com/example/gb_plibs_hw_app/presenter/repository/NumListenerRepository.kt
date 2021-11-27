package com.example.gb_plibs_hw_app.presenter.repository

import com.example.gb_plibs_hw_app.presenter.models.CounterModel

interface NumListenerRepository {

    fun changeNum(inputNum: CounterModel): Int
}