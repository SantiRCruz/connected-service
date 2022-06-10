package com.example.connectedhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import com.example.connectedhub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()
        animations()
        startTimer()
    }

    private fun startTimer() {
        object : CountDownTimer(2000,1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val i = Intent(this@MainActivity,HomeActivity::class.java)
                startActivity(i)
                finish()
            }
        }.start()
    }

    private fun animations() {
        binding.imgLogo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.logo))
        binding.txtTitle.startAnimation(AnimationUtils.loadAnimation(this,R.anim.title))
    }
}