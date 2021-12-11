package com.example.gb_plibs_hw_app.presentation.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gb_plibs_hw_app.databinding.FragmentDetailsBinding
import com.example.gb_plibs_hw_app.presentation.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment

class DetailsFragment(private val user: String) : MvpAppCompatFragment(), DetailsView, BackButtonListener {

    companion object {
        fun newInstance(user: String) = DetailsFragment(user = user)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailTv.text = user
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