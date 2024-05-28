package com.miempresa.semana12.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.miempresa.semana12.MyApplication
import com.miempresa.semana12.database.entities.Mascota
import kotlinx.coroutines.launch

class InsertMascotaViewModel(val app: Application): AndroidViewModel(app) {
    fun grabar(mascota: Mascota) {
        viewModelScope.launch {
            (app as MyApplication).database.getMascotaDao().insertMascota(mascota)
        }
    }

    fun reiniciarBaseDeDatos() {
        viewModelScope.launch {
            (app as MyApplication).database.getMascotaDao().eliminarTodos()
        }
    }
}