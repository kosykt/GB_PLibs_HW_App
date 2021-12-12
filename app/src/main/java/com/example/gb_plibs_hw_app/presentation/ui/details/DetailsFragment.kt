package com.example.gb_plibs_hw_app.presentation.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.gb_plibs_hw_app.databinding.FragmentDetailsBinding
import com.example.gb_plibs_hw_app.domain.users.model.UserModel
import com.example.gb_plibs_hw_app.presentation.App
import com.example.gb_plibs_hw_app.presentation.ui.base.BackButtonListener
import com.example.gb_plibs_hw_app.presentation.ui.imageloading.GlideImageLoader
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DetailsFragment() : MvpAppCompatFragment(), DetailsView,
    BackButtonListener {

    private var _binding: FragmentDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val userModel: UserModel by lazy {
        requireArguments().getSerializable(KEY_USER_MODEL) as UserModel
    }

    private val presenter by moxyPresenter {
        DetailsPresenter(
            router = App.instance.router,
            user = userModel
        )
    }

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
        binding.detailTv.text = userModel.login
        GlideImageLoader().loadInto(userModel.avatarUrl, binding.detailIv)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    companion object {

        private const val KEY_USER_MODEL = "KEY_USER_MODEL"

        fun newInstance(user: UserModel): DetailsFragment{
            return DetailsFragment().apply {
                arguments = bundleOf(KEY_USER_MODEL to user)
            }
        }
    }

    override fun showDetails() {
        presenter.userDetails()
    }
}