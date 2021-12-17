package com.example.gb_plibs_hw_app.presentation.ui.userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gb_plibs_hw_app.data.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.network.ApiHolder
import com.example.gb_plibs_hw_app.data.repository.userdetails.GithubUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.databinding.FragmentUserDetailsBinding
import com.example.gb_plibs_hw_app.domain.userdetails.model.DomainUserDetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import com.example.gb_plibs_hw_app.presentation.App
import com.example.gb_plibs_hw_app.presentation.ui.base.BackButtonListener
import com.example.gb_plibs_hw_app.presentation.ui.imageloading.GlideImageLoader
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView,
    BackButtonListener {

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val domainUsersModel: DomainUsersModel by lazy {
        requireArguments().getSerializable(KEY_USER_MODEL) as DomainUsersModel
    }

    private val status by lazy { NetworkStatus(requireContext().applicationContext) }

    private val presenter by moxyPresenter {
        UserDetailsPresenter(
            router = App.instance.router,
            domainUsersModel = domainUsersModel,
            userDetailsRepository = GithubUserDetailsRepositoryImpl(
                networkStatus = status,
                retrofitService = ApiHolder.retrofitService,
                db = AppDatabase.instance
            )
        )
    }

    private val adapter by lazy {
        DetailsAdapter(
            itemClickListener = presenter::onRepoClicked
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.detailRecycler.adapter = adapter

        binding.detailTv.text = domainUsersModel.login
        GlideImageLoader().loadInto(domainUsersModel.avatarUrl, binding.detailIv)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    override fun showUserRepos(repos: List<DomainUserDetailsModel>) {
        adapter.submitList(repos)
    }

    companion object {

        private const val KEY_USER_MODEL = "KEY_USER_MODEL"

        fun newInstance(domainUsersModel: DomainUsersModel): UserDetailsFragment {
            return UserDetailsFragment().apply {
                arguments = bundleOf(KEY_USER_MODEL to domainUsersModel)
            }
        }
    }
}