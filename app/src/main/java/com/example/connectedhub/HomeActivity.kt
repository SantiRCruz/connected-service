package com.example.connectedhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.connectedhub.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        observeDestination()
    }

    private fun observeDestination() {
        navController.addOnDestinationChangedListener{ c,d,a ->
            when(d.id){
                R.id.homeFragment->{binding.bottomNavigationView.visibility = View.GONE}
                R.id.detailFragment->{binding.bottomNavigationView.visibility = View.VISIBLE}
            }
        }
    }
}