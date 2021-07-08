package com.example.mobiledeviceprogramming.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobiledeviceprogramming.databinding.FragmentTabBinding
import com.example.mobiledeviceprogramming.utils.DataDummy

class TabFragment : Fragment() {

    private var _binding: FragmentTabBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTabBinding.inflate(inflater, container, false)
        val data = if (arguments?.getString(TYPE) == "TV") {
            DataDummy.getDataTV()
        } else {
            DataDummy.getDataMovie()
        }

        binding.rvSiaran.adapter = SiaranAdapter(data)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val TYPE = "type"

        fun withData(type: String): TabFragment {
            return TabFragment().apply {
                arguments = Bundle().apply {
                    putString(TYPE, type)
                }
            }
        }
    }
}