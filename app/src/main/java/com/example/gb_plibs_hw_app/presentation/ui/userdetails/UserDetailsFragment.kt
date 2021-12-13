package com.example.gb_plibs_hw_app.presentation.ui.userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gb_plibs_hw_app.data.network.ApiHolder
import com.example.gb_plibs_hw_app.data.repository.userdetails.GithubUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.databinding.FragmentUserDetailsBinding
import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel
import com.example.gb_plibs_hw_app.domain.users.model.UsersListModel
import com.example.gb_plibs_hw_app.presentation.App
import com.example.gb_plibs_hw_app.presentation.ui.base.BackButtonListener
import com.example.gb_plibs_hw_app.presentation.ui.imageloading.GlideImageLoader
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment() : MvpAppCompatFragment(), UserDetailsView,
    BackButtonListener {

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val usersListModel: UsersListModel by lazy {
        requireArguments().getSerializable(KEY_USER_MODEL) as UsersListModel
    }

    private val presenter by moxyPresenter {
        UserDetailsPresenter(
            router = App.instance.router,
            usersList = usersListModel,
            userDetailsRepository = GithubUserDetailsRepositoryImpl(ApiHolder.retrofitService)
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

        binding.detailTv.text = usersListModel.login
        GlideImageLoader().loadInto(usersListModel.avatarUrl, binding.detailIv)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    override fun showUserRepos(repos: List<UserDetailsModel>) {
        adapter.submitList(repos)
    }

    companion object {

        private const val KEY_USER_MODEL = "KEY_USER_MODEL"

        fun newInstance(usersList: UsersListModel): UserDetailsFragment{
            return UserDetailsFragment().apply {
                arguments = bundleOf(KEY_USER_MODEL to usersList)
            }
        }
    }
}