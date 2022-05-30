package com.nebvuu.tothetop.data.repository

import androidx.lifecycle.LiveData
import com.nebvuu.tothetop.data.database.PeakDao
import com.nebvuu.tothetop.data.entities.Peak

class PeakRepository(private val peakDao: PeakDao) {

    val readAllPeaks: LiveData<List<Peak>> = peakDao.readAllPeaks()

    suspend fun addPeak(peak: Peak){
        peakDao.addPeak(peak)
    }
}