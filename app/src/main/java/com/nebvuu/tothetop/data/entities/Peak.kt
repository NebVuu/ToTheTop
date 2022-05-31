package com.nebvuu.tothetop.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "peak_table")
data class Peak(
    @PrimaryKey(autoGenerate = true) val peakHeight: Int,
    val peakName: String,
    val date: Int,
    val mountain: String,
    val country: String,
    val description: String
) {
}