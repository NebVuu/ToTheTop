package com.nebvuu.tothetop.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "peak_table")
data class Peak(
    @PrimaryKey(autoGenerate = false) val peakHeight: Int,
    val peakName: String,
    val date: Date,
    val mountain: String,
    val country: String
) {
}