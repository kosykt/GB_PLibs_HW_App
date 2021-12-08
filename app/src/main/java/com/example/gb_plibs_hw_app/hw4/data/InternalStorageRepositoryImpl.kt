package com.example.gb_plibs_hw_app.hw4.data

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.gb_plibs_hw_app.hw4.domain.InternalStorageRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.internal.operators.completable.CompletableCreate
import java.io.ByteArrayOutputStream
import java.io.File

class InternalStorageRepositoryImpl(private val context: Context) : InternalStorageRepository {

    companion object {
        private const val FILE_JPG_NAME = "JPG_picture.jpg"
        private const val FILE_PNG_NAME = "PNG_picture.png"
    }

    override fun getImageJPG(): Single<Bitmap> = Single.create { emitter ->
        val file = createFileImageJPGInInternalStorage()
        val bitmap = BitmapFactory.decodeStream(file.inputStream())
        emitter.onSuccess(bitmap)
    }

    override fun getImagePNG(): Single<Bitmap> = Single.create { emitter ->
        val file = File(context.filesDir, FILE_PNG_NAME)
        val bitmap = BitmapFactory.decodeStream(file.inputStream())
        emitter.onSuccess(bitmap)
    }

    override fun convertJPGtoPNG(bitmap: Bitmap): Completable =
        CompletableCreate { emitter ->
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
            val filePNG = File(context.filesDir, FILE_PNG_NAME)
            filePNG.writeBytes(byteArrayOutputStream.toByteArray())
            emitter.onComplete()
        }

    private fun createFileImageJPGInInternalStorage(): File {
        val file = File(context.filesDir, FILE_JPG_NAME)
        if (!file.exists()) {
            val inputStream = context.assets.open(FILE_JPG_NAME)
            file.writeBytes(inputStream.readBytes())
        }
        return file
    }
}