package com.nebvuu.tothetop.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nebvuu.tothetop.data.entities.Peak

@Dao
interface PeakDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPeak(peak: Peak)

    @Query("SELECT * FROM peak_table ORDER BY peakHeight DESC")
    fun readAllPeaks(): LiveData<List<Peak>>



}