package com.example.qusionapp.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qusionapp.data.ItemClickListener
import com.example.qusionapp.data.Item
import com.example.qusionapp.databinding.ItemBinding

class ItemsAdapter(
    private val items: List<Item>,
    private val callback: ItemClickListener) :
    RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: ItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemData: Item, callback: ItemClickListener) {
            binding.apply {
                item = itemData
                listener = callback
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], callback)
    }

    override fun getItemCount() = items.size
}