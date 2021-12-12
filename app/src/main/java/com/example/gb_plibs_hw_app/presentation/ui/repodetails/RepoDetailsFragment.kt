package com.example.gb_plibs_hw_app.presentation.ui.repodetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.gb_plibs_hw_app.data.nerwork.ApiHolder
import com.example.gb_plibs_hw_app.data.repository.GetGithubRepoRepositoryImpl
import com.example.gb_plibs_hw_app.databinding.FragmentRepoDetailsBinding
import com.example.gb_plibs_hw_app.domain.details.model.DetailsModel
import com.example.gb_plibs_hw_app.domain.repodetails.model.RepoModel
import com.example.gb_plibs_hw_app.presentation.App
import com.example.gb_plibs_hw_app.presentation.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepoDetailsFragment : MvpAppCompatFragment(), RepoDetailsView, BackButtonListener {

    private var _binding: FragmentRepoDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val presenter by moxyPresenter {
        RepoDetailsPresenter(
            router = App.instance.router,
            detailsModel = detailsModel,
            githubRepoRepository = GetGithubRepoRepositoryImpl(ApiHolder.retrofitService)
        )
    }

    private val detailsModel: DetailsModel by lazy {
        requireArguments().getSerializable(KEY_REPO_MODEL) as DetailsModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepoDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    companion object{

        private const val KEY_REPO_MODEL = "KEY_REPO_MODEL"

        fun newInstance(repo: DetailsModel):RepoDetailsFragment{
            return RepoDetailsFragment().apply {
                arguments = bundleOf(KEY_REPO_MODEL to repo)
            }
        }
    }

    override fun showRepoDetails(repoModel: RepoModel) {
        binding.repoTv.text = repoModel.forksCount.toString()
    }
}