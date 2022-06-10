package com.example.connectedhub.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.connectedhub.R
import com.example.connectedhub.databinding.ActivityHomeBinding
import com.example.connectedhub.databinding.FragmentDetailBinding


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private lateinit var binding: FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        updateData()

    }

    private fun updateData() {
        binding.txtTitle.text = args.name
        binding.imgCar.setImageResource(args.image)
    }
}