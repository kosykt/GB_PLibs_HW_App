package com.example.gb_plibs_hw_app.hw4.domain

import android.graphics.Bitmap
import io.reactivex.rxjava3.core.Single

class GetImageJPGUseCase(private val repository: InternalStorageRepository) {

    fun execute(): Single<Bitmap> {
        return repository.getImageJPG()
    }
}