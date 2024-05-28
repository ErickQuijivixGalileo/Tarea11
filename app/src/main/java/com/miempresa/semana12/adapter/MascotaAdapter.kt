package com.miempresa.semana12.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.miempresa.semana12.R
import com.miempresa.semana12.database.entities.Mascota
import com.miempresa.semana12.databinding.MascotaItemBinding

class MascotaAdapter(val list: ArrayList<Mascota>):
    RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {
    class MascotaViewHolder(val binding: MascotaItemBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MascotaViewHolder(MascotaItemBinding
            .inflate(LayoutInflater.from(parent.context),parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        holder.binding.nombre.text = list.get(position).nombre
        holder.binding.raza.text = list.get(position).raza
        holder.binding.dueno.text = list.get(position).dueno
        val imageResource = if (list.get(position).dueno == "Masculino") {
            R.drawable.hombre
        } else {
            R.drawable.mujer
        }

        holder.binding.image.setImageResource(imageResource)
    }

    fun loadNewItems(newList: List<Mascota>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

}