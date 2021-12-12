package com.example.gb_plibs_hw_app.presentation.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_plibs_hw_app.databinding.ItemDetailsBinding
import com.example.gb_plibs_hw_app.domain.details.model.DetailsModel

class DetailsAdapter(
    private val itemClickListener: () -> Unit
) : ListAdapter<DetailsModel, DetailsAdapter.DetailsViewHolder>(GithubDetailsItemCallBack) {


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
        fun showDetails(details: DetailsModel) {
            vb.root.setOnClickListener { itemClickListener() }
            vb.itemDetailTv.text = details.name
        }
    }
}

object GithubDetailsItemCallBack : DiffUtil.ItemCallback<DetailsModel>() {

    override fun areItemsTheSame(oldItem: DetailsModel, newItem: DetailsModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DetailsModel, newItem: DetailsModel): Boolean {
        return oldItem == newItem
    }
}
