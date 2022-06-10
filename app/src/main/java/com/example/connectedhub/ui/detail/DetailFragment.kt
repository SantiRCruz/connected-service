package com.example.connectedhub.ui.detail

import android.os.Bundle
import android.os.CountDownTimer
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
    private var showLock = false
    private var showUnlock = false
    private var showEngine = false
    private val args by navArgs<DetailFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        updateData()

        clicks()

    }

    private fun clicks() {
        binding.imgLockDoors.setOnClickListener {
            showLock = !showLock
            if (!showLock) {
                binding.lockDoors.visibility = View.GONE
            } else {
                binding.lockDoors.visibility = View.VISIBLE
            }
        }
        binding.imgStartEngine.setOnClickListener {
            showEngine = !showEngine
            if (!showEngine) {
                binding.startEngine.visibility = View.GONE
                binding.startEngine2.visibility = View.GONE
            } else {
                binding.startEngine.visibility = View.VISIBLE
                binding.startEngine2.visibility = View.VISIBLE
            }
        }
        binding.imgStartEngine2.setOnClickListener {
            showEngine = !showEngine
            if (!showEngine) {
                binding.startEngine.visibility = View.GONE
                binding.startEngine2.visibility = View.GONE
            } else {
                binding.startEngine.visibility = View.VISIBLE
                binding.startEngine2.visibility = View.VISIBLE
            }
        }
        binding.imgUnlockDoors.setOnClickListener {
            showUnlock = !showUnlock
            if (!showUnlock) {
                binding.unlockDoors.visibility = View.GONE
            } else {
                binding.unlockDoors.visibility = View.VISIBLE
            }
        }
    }

    private fun updateData() {
        binding.txtTitle.text = args.name
        binding.imgCar.setImageResource(args.image)
    }
}