package com.example.gb_plibs_hw_app.presenter.usecase

import com.example.gb_plibs_hw_app.presenter.models.CounterModel
import com.example.gb_plibs_hw_app.presenter.repository.NumListenerRepository

class ChangeNumOnButtonUseCase(private val numListenerRepository: NumListenerRepository) {

    fun execute(param: CounterModel): Int {
        return numListenerRepository.changeNum(inputNum = param)
    }
}