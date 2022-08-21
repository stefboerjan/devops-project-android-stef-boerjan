package com.example.breakingbadapp.screens.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbadapp.databinding.ListItemEpisodeBinding
import com.example.breakingbadapp.network.EpisodeProperty

class EpisodeAdapter(private val onClickListener: OnClickListener) : ListAdapter<EpisodeProperty, EpisodeAdapter.ViewHolder>(EpisodeDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListItemEpisodeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: EpisodeProperty
        ) {
            binding.episode = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemEpisodeBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class OnClickListener(val clickListener: (episodeProperty: EpisodeProperty) -> Unit) {
        fun onClick(episodeProperty: EpisodeProperty) = clickListener(episodeProperty)
    }
}

class EpisodeDiffCallback : DiffUtil.ItemCallback<EpisodeProperty>() {
    override fun areItemsTheSame(oldItem: EpisodeProperty, newItem: EpisodeProperty): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: EpisodeProperty,
        newItem: EpisodeProperty
    ): Boolean {
        return oldItem == newItem
    }
}
