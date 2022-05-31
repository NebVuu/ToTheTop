package com.nebvuu.tothetop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.nebvuu.tothetop.R
import com.nebvuu.tothetop.data.entities.Peak
import com.nebvuu.tothetop.databinding.ActivityAddPeakBinding

class AddPeakActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddPeakBinding
    private lateinit var peakViewModel: PeakViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_peak)
        binding = ActivityAddPeakBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peakViewModel = ViewModelProvider(this).get(PeakViewModel::class.java)

        val addPeak = binding.btnAdd
        addPeak.setOnClickListener {
            insertDataToDatabase()
            finish()
        }
    }

    private fun insertDataToDatabase() {
        val peakHeight = binding.etPeakHeight.text.toString()
        val peakName = binding.etPeakName.text.toString()
        val date = binding.etDate.text.toString()
        val mountainName = binding.etMountainName.text.toString()
        val country = binding.etCountry.text.toString()
        val description = binding.etMountainDescription.text.toString()
        //TODO check fields

        val peak = Peak(Integer.parseInt(peakHeight), peakName,Integer.parseInt(date), mountainName, country, description)
        peakViewModel.addPeak(peak)
        Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show();
    }
}