package com.example.gb_plibs_hw_app.presentation.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_plibs_hw_app.databinding.ItemUserBinding
import com.example.gb_plibs_hw_app.domain.users.model.UsersModel
import com.example.gb_plibs_hw_app.presentation.ui.imageloading.ImageLoader

class UsersAdapter(
    private val itemClickListener: (UsersModel) -> Unit,
    private val imageLoader: ImageLoader<ImageView>
) : ListAdapter<UsersModel, UsersAdapter.UserViewHolder>(GithubUserItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(vb =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.showUser(currentList[position])
    }

    inner class UserViewHolder(private val vb: ItemUserBinding) : RecyclerView.ViewHolder(vb.root) {

        fun showUser(usersModel: UsersModel) {
            vb.root.setOnClickListener { itemClickListener(usersModel) }

            vb.tvLogin.text = usersModel.login

            imageLoader.loadInto(usersModel.avatarUrl, vb.userImage)
        }
    }
}

object GithubUserItemCallback : DiffUtil.ItemCallback<UsersModel>() {

    override fun areItemsTheSame(oldItem: UsersModel, newItem: UsersModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: UsersModel, newItem: UsersModel): Boolean {
        return oldItem == newItem
    }
}