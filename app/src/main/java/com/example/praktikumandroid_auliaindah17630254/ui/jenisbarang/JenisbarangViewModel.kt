package com.example.praktikumandroid_auliaindah17630254.ui.jenisbarang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikumandroid_auliaindah17630254.model.Jenisbarang
import com.example.praktikumandroid_auliaindah17630254.network.Api
import kotlinx.coroutines.launch

class JenisbarangViewModel : ViewModel() {
    private val _response = MutableLiveData<Jenisbarang>()

    val response: LiveData<Jenisbarang>
        get() = _response

    init {
        setResponse()
    }

    private fun setResponse() {
        viewModelScope.launch {
            try {
                val listResult = Api.retrofitService.getJenisbarang()
                _response.value = listResult
            } catch (e: Exception) {
                _response.value = null
            }
        }
    }
}