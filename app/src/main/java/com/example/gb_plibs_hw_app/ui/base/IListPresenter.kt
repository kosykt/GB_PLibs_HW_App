package com.example.gb_plibs_hw_app.ui.base

interface IListPresenter<V : IItemView> {

    var itemClickListener: () -> Unit

    fun getCount(): Int

    fun bindView(view: V)
}