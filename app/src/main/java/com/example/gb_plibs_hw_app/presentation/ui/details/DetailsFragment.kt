package com.example.gb_plibs_hw_app.presentation.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gb_plibs_hw_app.databinding.FragmentDetailsBinding
import com.example.gb_plibs_hw_app.presentation.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment

class DetailsFragment : MvpAppCompatFragment(), DetailsView, BackButtonListener {

    companion object {

    }

    private var _binding: FragmentDetailsBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean {
//        presenter.backPressed()
        return true
    }
}