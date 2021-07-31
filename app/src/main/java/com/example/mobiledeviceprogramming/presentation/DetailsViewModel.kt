package com.example.mobiledeviceprogramming.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiledeviceprogramming.data.Repository
import com.example.mobiledeviceprogramming.domain.Siaran
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: Repository) : ViewModel() {
    fun deleteSiaran(item: Siaran) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteSiaran(item)
    }
}