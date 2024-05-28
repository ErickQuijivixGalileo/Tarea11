package com.miempresa.semana12.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.miempresa.semana12.MyApplication
import com.miempresa.semana12.database.entities.Mascota
import kotlinx.coroutines.launch

class SelectMascotaViewModel(val app: Application): AndroidViewModel(app) {
    private val _mascotas: MutableLiveData<List<Mascota>> = MutableLiveData(emptyList())
    val mascotas: LiveData<List<Mascota>> = _mascotas

    fun loadMascotas() {
        viewModelScope.launch {
            val arrayData = (app as MyApplication).database.getMascotaDao().getAllMascota()
            _mascotas.postValue(arrayData)
        }
    }
}