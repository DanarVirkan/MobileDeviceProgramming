package com.example.mobiledeviceprogramming.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiledeviceprogramming.data.Repository
import com.example.mobiledeviceprogramming.domain.Siaran
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val tv = MutableLiveData<List<Siaran>>()
    private val movie = MutableLiveData<List<Siaran>>()

    fun setTV() = viewModelScope.launch(Dispatchers.IO) {
        repository.getTV().collect {
            tv.postValue(it)
        }
    }

    fun getTV() = tv
    fun setMovie() = viewModelScope.launch(Dispatchers.IO) {
        repository.getMovie().collect {
            movie.postValue(it)
        }
    }

    fun getMovie() = movie

}