package com.example.connectedhub.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.connectedhub.databinding.ItemCarBinding
import com.example.connectedhub.models.Car

class CarsAdapter(private val cars : List<Car>):RecyclerView.Adapter<CarsAdapter.CarsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val itemBinding = ItemCarBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CarsViewHolder(itemBinding,)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.bind(cars[position%3])
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    inner class CarsViewHolder(private val binding : ItemCarBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(car : Car){
            binding.imgCar.setImageResource(car.image)
            binding.txtTitle.text = car.name
        }
    }
}