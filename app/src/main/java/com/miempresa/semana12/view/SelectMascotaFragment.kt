package com.miempresa.semana12.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.miempresa.semana12.R
import com.miempresa.semana12.adapter.MascotaAdapter
import com.miempresa.semana12.databinding.FragmentSelectMascotaBinding
import com.miempresa.semana12.viewModel.SelectMascotaViewModel


class SelectMascotaFragment : Fragment() {
    lateinit var binding: FragmentSelectMascotaBinding
    lateinit var viewModel: SelectMascotaViewModel
    val adapter = MascotaAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectMascotaBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(SelectMascotaViewModel::class.java)
        binding.rvMascotas.adapter = adapter
        binding.rvMascotas.layoutManager = LinearLayoutManager(context)
        viewModel.mascotas.observe(viewLifecycleOwner) { newList ->
            Log.d("TEST", "${newList.size}")
            adapter.loadNewItems(newList)
        }
        viewModel.loadMascotas()
        return binding.root
    }
}