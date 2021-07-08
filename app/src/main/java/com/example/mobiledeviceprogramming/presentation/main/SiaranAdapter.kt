package com.example.mobiledeviceprogramming.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiledeviceprogramming.data.Siaran
import com.example.mobiledeviceprogramming.databinding.ItemsBinding

class SiaranAdapter(private val data: ArrayList<Siaran>) :
    RecyclerView.Adapter<SiaranAdapter.SiaranViewHolder>() {
    class SiaranViewHolder(val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(siaran: Siaran) {
            binding.imagePoster.setImageResource(siaran.cover)
            binding.ratingSiaran.text = siaran.rating
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiaranViewHolder {
        val view = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SiaranViewHolder(view)
    }

    override fun onBindViewHolder(holder: SiaranViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}