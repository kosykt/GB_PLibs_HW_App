package com.example.gb_plibs_hw_app.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_plibs_hw_app.databinding.ItemUserBinding
import com.example.gb_plibs_hw_app.model.GithubUserModel
import com.example.gb_plibs_hw_app.ui.imageloading.ImageLoader

class UsersAdapter(
    private val itemClickListener: (GithubUserModel) -> Unit,
    private val imageLoader: ImageLoader<ImageView>
) : ListAdapter<GithubUserModel, UsersAdapter.UserViewHolder>(GithubUserItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.showUser(currentList[position])
    }

    inner class UserViewHolder(private val vb: ItemUserBinding) : RecyclerView.ViewHolder(vb.root) {

        fun showUser(user: GithubUserModel) {
            vb.root.setOnClickListener { itemClickListener(user) }

            vb.tvLogin.text = user.login

            imageLoader.loadInto(user.avatarUrl, vb.userImage)
        }
    }
}

object GithubUserItemCallback : DiffUtil.ItemCallback<GithubUserModel>() {

    override fun areItemsTheSame(oldItem: GithubUserModel, newItem: GithubUserModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GithubUserModel, newItem: GithubUserModel): Boolean {
        return oldItem == newItem
    }
}