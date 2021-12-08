package com.example.gb_plibs_hw_app.hw4.ui.fragment

import android.graphics.Bitmap
import com.example.gb_plibs_hw_app.hw4.domain.ConvertJPGToPNGUseCase
import com.example.gb_plibs_hw_app.hw4.domain.GetImageJPGUseCase
import com.example.gb_plibs_hw_app.hw4.domain.GetImagePNGUseCase
import com.example.gb_plibs_hw_app.hw4.domain.InternalStorageRepository
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class ConvertPicturePresenter(
    repository: InternalStorageRepository,
    private val router: Router
): MvpPresenter<ConvertPictureView>() {

    private val getImageJPGUseCase = GetImageJPGUseCase(repository)
    private val getImagePNGUseCase = GetImagePNGUseCase(repository)
    private val convertJPGToPNGUseCase = ConvertJPGToPNGUseCase(repository)

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun getImageJPG() {
        getImageJPGUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showImageJPG(it)
                },
                {
                    viewState.showError(it.message)
                }
            )
    }

    fun convertImageToPNG(bitmap: Bitmap) {
        convertJPGToPNGUseCase.execute(bitmap)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    getImagePNG()
                },
                {
                    viewState.showError(it.message)
                }
            )
    }

    private fun getImagePNG() {
        getImagePNGUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showImagePNG(it)
                    viewState.showImagePNGLabel()
                },
                {
                    viewState.showError(it.message)
                }
            )
    }
}