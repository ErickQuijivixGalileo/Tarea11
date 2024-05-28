package com.miempresa.semana12.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.miempresa.semana12.R
import com.miempresa.semana12.database.entities.Mascota
import com.miempresa.semana12.databinding.FragmentInsertMascotaBinding
import com.miempresa.semana12.viewModel.InsertMascotaViewModel


class InsertMascotaFragment : Fragment() {
    lateinit var binding: FragmentInsertMascotaBinding
    lateinit var viewModel: InsertMascotaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsertMascotaBinding.inflate(inflater, container, false)
        binding.btnGrabar.setOnClickListener {
            val nombre = binding.nombre.text.toString()
            val raza = binding.raza.text.toString()
            val genero = when {
                binding.masculino.isChecked -> "Masculino"
                binding.femenino.isChecked -> "Femenino"
                else -> "No especificado"
            }
            val mascota = Mascota(nombre = nombre, raza = raza, dueno = genero)

            binding.raza.text.clear()
            binding.nombre.text.clear()

            viewModel.grabar(mascota)
        }

        binding.btnListado.setOnClickListener {
            findNavController().navigate(R.id.action_insertMascotaFragment_to_selectMascotaFragment)
        }
        binding.btnReiniciar.setOnClickListener {
            viewModel.reiniciarBaseDeDatos()
        }
        viewModel = ViewModelProvider(this).get(InsertMascotaViewModel::class.java)
        return binding.root
    }

}