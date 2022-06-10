package com.example.connectedhub.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.inspector.IntFlagMapping
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.connectedhub.R
import com.example.connectedhub.databinding.FragmentHomeBinding
import com.example.connectedhub.models.Car

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var dataCar : Car
    private val cars = arrayListOf<Car>(
        Car("AUDI A8", R.drawable.a8),
        Car("AUDI Q7", R.drawable.q7),
        Car("BMW i8", R.drawable.i8)
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        animations()
        obtainData()
        clicks()
    }

    private fun clicks() {
        binding.imgSelect.setOnClickListener {
            dataCar = cars[binding.viewPager2.currentItem % 3]
            val action  = HomeFragmentDirections.actionHomeFragmentToDetailFragment(dataCar.name,dataCar.image)
            findNavController().navigate(action)
        }
    }

    private fun obtainData() {
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewPager2.adapter = CarsAdapter(cars)
        binding.viewPager2.setCurrentItem(Int.MAX_VALUE/2, false)
        binding.imgLeft.setOnClickListener {
            binding.viewPager2.currentItem = binding.viewPager2.currentItem - 1
        }
        binding.imgRight.setOnClickListener {
            binding.viewPager2.currentItem = binding.viewPager2.currentItem + 1
        }

    }

    private fun animations() {
        binding.container.startAnimation(
            AnimationUtils.loadAnimation(
                requireContext(),
                R.anim.container_home
            )
        )
    }

}