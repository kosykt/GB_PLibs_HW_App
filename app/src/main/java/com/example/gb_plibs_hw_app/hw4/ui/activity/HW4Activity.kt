package com.example.gb_plibs_hw_app.hw4.ui.activity

import com.example.gb_plibs_hw_app.App
import com.example.gb_plibs_hw_app.R
import com.example.gb_plibs_hw_app.ui.base.BackButtonListener
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class HW4Activity : MvpAppCompatActivity(R.layout.activity_hw4), HW4View {

    private val navigator = AppNavigator(this, R.id.container_hw4)
    private val presenter by moxyPresenter { HW4Presenter(App.instance.router) }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backPressed()
    }
}