package com.example.gb_plibs_hw_app.presentation.ui.imageloading

interface ImageLoader<T> {

    fun loadInto(url: String, container: T)
}