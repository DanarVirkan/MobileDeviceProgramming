package com.example.mobiledeviceprogramming.presentation.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiledeviceprogramming.databinding.ItemsBinding
import com.example.mobiledeviceprogramming.domain.Siaran
import com.example.mobiledeviceprogramming.presentation.DetailsActivity
import com.example.mobiledeviceprogramming.utils.Constant.SIARAN

class SiaranAdapter(private val data: ArrayList<Siaran>) :
    RecyclerView.Adapter<SiaranAdapter.SiaranViewHolder>() {
    class SiaranViewHolder(val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(siaran: Siaran) {
            binding.imagePoster.setImageResource(siaran.cover)
            binding.ratingSiaran.text = siaran.rating
            binding.imagePoster.setOnClickListener {
                val intent = Intent(binding.root.context, DetailsActivity::class.java)
                intent.putExtra(SIARAN, siaran)
                startActivity(binding.root.context, intent, null)
            }
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