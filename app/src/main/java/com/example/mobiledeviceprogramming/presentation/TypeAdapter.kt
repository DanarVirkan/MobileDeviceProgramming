package com.example.mobiledeviceprogramming.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mobiledeviceprogramming.R

class TypeAdapter(context: Context, list: Array<String>) : ArrayAdapter<String>(context, 0, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val type = getItem(position)
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.dropdown_spinner, parent, false)
        var drawable = R.drawable.movie
        if (type == "TV") {
            drawable = R.drawable.tv
        }
        view.findViewById<ImageView>(R.id.spinnerIcon).setImageResource(drawable)
        view.findViewById<TextView>(R.id.spinnerText).text = type
        return view
    }
}