package com.example.gb_plibs_hw_app.hw4.domain

import android.graphics.Bitmap
import io.reactivex.rxjava3.core.Completable

class ConvertJPGToPNGUseCase(private val repository: InternalStorageRepository) {

    fun execute(bitmap: Bitmap): Completable {
        return repository.convertJPGtoPNG(bitmap)
    }
}