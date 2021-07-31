package com.example.mobiledeviceprogramming.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiledeviceprogramming.data.Repository
import com.example.mobiledeviceprogramming.domain.Siaran
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InputViewModel(private val repository: Repository) : ViewModel() {
    fun insertSiaran(item: Siaran) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertSiaran(item)
    }

    fun updateSiaran(item: Siaran) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateSiaran(item)
    }
}