package com.example.gb_plibs_hw_app.hw4.domain

class GetImagePNGUseCase(private val repository: InternalStorageRepository) {

    fun execute() = repository.getImagePNG()
}