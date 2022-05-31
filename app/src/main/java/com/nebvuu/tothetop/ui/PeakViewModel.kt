package com.nebvuu.tothetop.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.nebvuu.tothetop.data.database.PeaksDatabase
import com.nebvuu.tothetop.data.entities.Peak
import com.nebvuu.tothetop.data.repository.PeakRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeakViewModel(application: Application): AndroidViewModel(application) {

    val readAllPeaks: LiveData<List<Peak>>
    private val repository: PeakRepository

    init{
        val peakDao = PeaksDatabase.getDatabase(application).peakDao()
        repository = PeakRepository(peakDao)
        readAllPeaks = repository.readAllPeaks
    }

    fun addPeak(peak: Peak){
        viewModelScope.launch (Dispatchers.IO){
            repository.addPeak(peak)
        }
    }

    fun deletePeak(peak: Peak){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePeak(peak)
        }
    }

}