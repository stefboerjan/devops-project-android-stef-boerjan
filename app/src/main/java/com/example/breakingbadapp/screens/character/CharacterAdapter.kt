package com.example.breakingbadapp.screens.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbadapp.databinding.ListItemCharacterBinding
import com.example.breakingbadapp.network.CharacterProperty

class CharacterAdapter(private val onClickListener: OnClickListener) : ListAdapter<CharacterProperty, CharacterAdapter.ViewHolder>(CharacterDiffCallback()) {
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

    class ViewHolder private constructor(val binding: ListItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: CharacterProperty
        ) {
            binding.character = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemCharacterBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class OnClickListener(val clickListener: (character: CharacterProperty) -> Unit) {
        fun onClick(character: CharacterProperty) = clickListener(character)
    }
}

class CharacterDiffCallback : DiffUtil.ItemCallback<CharacterProperty>() {
    override fun areItemsTheSame(oldItem: CharacterProperty, newItem: CharacterProperty): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CharacterProperty,
        newItem: CharacterProperty
    ): Boolean {
        return oldItem == newItem
    }
}
