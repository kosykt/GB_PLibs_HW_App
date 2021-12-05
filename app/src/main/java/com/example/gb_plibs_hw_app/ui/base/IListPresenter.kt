package com.example.gb_plibs_hw_app.ui.base

import com.example.gb_plibs_hw_app.ui.users.UserItemView

interface IListPresenter<V : IItemView> {

    var itemClickListener: ((UserItemView)) -> Unit

    fun getCount(): Int

    fun bindView(view: V)
}