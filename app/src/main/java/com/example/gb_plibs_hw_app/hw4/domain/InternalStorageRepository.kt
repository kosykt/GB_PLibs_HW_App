package com.example.gb_plibs_hw_app.hw4.domain

import android.graphics.Bitmap
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface InternalStorageRepository {

    fun getImageJPG(): Single<Bitmap>

    fun getImagePNG(): Single<Bitmap>

    fun convertJPGtoPNG(bitmap: Bitmap): Completable
}