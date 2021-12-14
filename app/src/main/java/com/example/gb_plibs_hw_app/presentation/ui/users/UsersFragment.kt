package com.example.gb_plibs_hw_app.presentation.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.db.connectivity.NetworkStatus
import com.example.gb_plibs_hw_app.presentation.App
import com.example.gb_plibs_hw_app.databinding.FragmentUsersBinding
import com.example.gb_plibs_hw_app.data.repository.users.GithubUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.domain.users.model.UsersModel
import com.example.gb_plibs_hw_app.data.network.ApiHolder
import com.example.gb_plibs_hw_app.presentation.ui.base.BackButtonListener
import com.example.gb_plibs_hw_app.presentation.ui.imageloading.GlideImageLoader
import com.example.gb_plibs_hw_app.presentation.ui.users.adapter.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private val status by lazy { NetworkStatus(requireContext().applicationContext) }

    private val presenter by moxyPresenter {
        UsersPresenter(
            router = App.instance.router,
            usersListRepository = GithubUsersListRepositoryImpl(
                networkStatus = status,
                retrofitService = ApiHolder.retrofitService,
                db = AppDatabase.instance
            )
        )
    }
    private var _binding: FragmentUsersBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        UsersAdapter(
            itemClickListener = presenter::onUserClicked,
            imageLoader = GlideImageLoader()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usersRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.usersRecycler.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun updateList(usersModel: List<UsersModel>) {
        adapter.submitList(usersModel)
    }

    override fun showLoading() {
        binding.loadingView.isVisible = true
        binding.usersRecycler.isVisible = false
    }

    override fun hideLoading() {
        binding.loadingView.isVisible = false
        binding.usersRecycler.isVisible = true
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }
}