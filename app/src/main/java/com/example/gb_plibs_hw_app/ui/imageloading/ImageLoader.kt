package com.example.gb_plibs_hw_app.ui.imageloading

interface ImageLoader<T> {

    fun loadInto(url: String, container: T)
}