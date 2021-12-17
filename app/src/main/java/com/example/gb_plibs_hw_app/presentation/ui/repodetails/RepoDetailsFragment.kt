package com.example.gb_plibs_hw_app.presentation.ui.repodetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.ApiHolder
import com.example.gb_plibs_hw_app.data.repository.repodetails.GithubRepoRepositoryImpl
import com.example.gb_plibs_hw_app.databinding.FragmentRepoDetailsBinding
import com.example.gb_plibs_hw_app.domain.repodetails.model.DomainUserRepoModel
import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.example.gb_plibs_hw_app.presentation.App
import com.example.gb_plibs_hw_app.presentation.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepoDetailsFragment : MvpAppCompatFragment(), RepoDetailsView, BackButtonListener {

    private var _binding: FragmentRepoDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val status by lazy { NetworkStatus(requireContext().applicationContext) }

    private val presenter by moxyPresenter {
        RepoDetailsPresenter(
            router = App.instance.router,
            domainUserDetailsModel = domainUserDetailsModel,
            githubRepoRepository = GithubRepoRepositoryImpl(
                networkStatus = status,
                retrofitService = ApiHolder.retrofitService,
                db = AppDatabase.instance
            )
        )
    }

    private val domainUserDetailsModel: DomainUserDetailsModel by lazy {
        requireArguments().getSerializable(KEY_REPO_MODEL) as DomainUserDetailsModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        fun newInstance(repo: DomainUserDetailsModel): RepoDetailsFragment {
            return RepoDetailsFragment().apply {
                arguments = bundleOf(KEY_REPO_MODEL to repo)
            }
        }
    }

    override fun showRepoDetails(domainUserRepoModel: DomainUserRepoModel) {
        binding.repoTv.text = domainUserRepoModel.forksCount.toString()
    }
}