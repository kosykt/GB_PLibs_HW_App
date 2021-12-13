package com.example.gb_plibs_hw_app.presentation.ui.userdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_plibs_hw_app.databinding.ItemDetailsBinding
import com.example.gb_plibs_hw_app.domain.userdetails.model.UserDetailsModel

class DetailsAdapter(
    private val itemClickListener: (UserDetailsModel) -> Unit
) : ListAdapter<UserDetailsModel, DetailsAdapter.DetailsViewHolder>(GithubDetailsItemCallBack) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        return DetailsViewHolder(
            vb = ItemDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.showDetails(currentList[position])
    }

    inner class DetailsViewHolder(private val vb: ItemDetailsBinding) :
        RecyclerView.ViewHolder(vb.root) {
        fun showDetails(userDetails: UserDetailsModel) {
            vb.root.setOnClickListener { itemClickListener(userDetails) }
            vb.itemDetailTv.text = userDetails.name
        }
    }
}

object GithubDetailsItemCallBack : DiffUtil.ItemCallback<UserDetailsModel>() {

    override fun areItemsTheSame(oldItem: UserDetailsModel, newItem: UserDetailsModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: UserDetailsModel, newItem: UserDetailsModel): Boolean {
        return oldItem == newItem
    }
}
