package com.example.gb_plibs_hw_app.presentation.ui.repodetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.gb_plibs_hw_app.databinding.FragmentRepoDetailsBinding
import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import com.example.gb_plibs_hw_app.presentation.App
import com.example.gb_plibs_hw_app.presentation.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepoDetailsFragment : MvpAppCompatFragment(), RepoDetailsView, BackButtonListener {

    private var _binding: FragmentRepoDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val userDetailsModel: UserDetailsModel by lazy {
        requireArguments().getSerializable(KEY_REPO_MODEL) as UserDetailsModel
    }

    private val presenter by moxyPresenter {
            App.instance.appComponent.repoDetailsPresenterFactory().presenter(userDetailsModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepoDetailsBinding.inflate(inflater, container, false)
        return binding.root
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

        private const val KEY_REPO_MODEL = "KEY_REPO_MODEL"

        fun newInstance(repo: UserDetailsModel): RepoDetailsFragment {
            return RepoDetailsFragment().apply {
                arguments = bundleOf(KEY_REPO_MODEL to repo)
            }
        }
    }

    override fun showRepoDetails(domainUserRepoModel: DomainUserRepoModel) {
        binding.repoTv.text = domainUserRepoModel.forksCount.toString()
    }
}