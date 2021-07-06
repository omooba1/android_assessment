package com.david.recyclerapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.david.recyclerapp.databinding.NameItemBinding
import com.david.recyclerapp.models.Name

class NameAdapter(val names: List<Name>, var clickListener: OnNameItemClickListener) :
    RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    class NameViewHolder(var binding: NameItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(name: Name) {
            binding.profilePicture.setImageResource(name.profile)
            binding.firstName.text = name.first
            binding.lastName.text = name.last
        }

        fun initialize(name: Name, action: OnNameItemClickListener) {
            binding.profilePicture.setImageResource(name.profile)
            binding.firstName.text = name.first
            binding.lastName.text = name.last

            binding.root.setOnClickListener {
                action.onItemClick(name, adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val binding = NameItemBinding.inflate(LayoutInflater.from(parent.context))
        return NameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val name = names[position]
        holder.bind(name)
        holder.initialize(names[position], clickListener)
    }

    override fun getItemCount(): Int {
        return names.size
    }

}

interface OnNameItemClickListener {
    fun onItemClick(name: Name, position: Int)
}