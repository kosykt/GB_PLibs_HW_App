package com.example.gb_plibs_hw_app.presentation.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_plibs_hw_app.databinding.ItemUserBinding
import com.example.gb_plibs_hw_app.domain.users.model.DomainUsersModel
import com.example.gb_plibs_hw_app.presentation.ui.imageloading.ImageLoader

class UsersAdapter(
    private val itemClickListener: (DomainUsersModel) -> Unit,
    private val imageLoader: ImageLoader<ImageView>
) : ListAdapter<DomainUsersModel, UsersAdapter.UserViewHolder>(GithubUserItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            vb =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.showUser(currentList[position])
    }

    inner class UserViewHolder(private val vb: ItemUserBinding) : RecyclerView.ViewHolder(vb.root) {

        fun showUser(domainUsersModel: DomainUsersModel) {
            vb.root.setOnClickListener { itemClickListener(domainUsersModel) }

            vb.tvLogin.text = domainUsersModel.login

            imageLoader.loadInto(domainUsersModel.avatarUrl, vb.userImage)
        }
    }
}

object GithubUserItemCallback : DiffUtil.ItemCallback<DomainUsersModel>() {

    override fun areItemsTheSame(oldItem: DomainUsersModel, newItem: DomainUsersModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DomainUsersModel, newItem: DomainUsersModel): Boolean {
        return oldItem == newItem
    }
}