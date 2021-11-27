package com.example.gb_plibs_hw_app.model.repository

import com.example.gb_plibs_hw_app.presenter.models.CounterModel
import com.example.gb_plibs_hw_app.presenter.repository.NumListenerRepository

class NumListenerRepositoryImpl() : NumListenerRepository {

    override fun changeNum(inputNum: CounterModel): Int {

        return inputNum.num + 1
    }
}