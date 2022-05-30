package com.nebvuu.tothetop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nebvuu.tothetop.R
import com.nebvuu.tothetop.databinding.ActivityAddPeakBinding

class AddPeakActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddPeakBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_peak)
        binding = ActivityAddPeakBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addPeak = binding.btnAdd
        addPeak.setOnClickListener{
            finish()
        }
    }
}