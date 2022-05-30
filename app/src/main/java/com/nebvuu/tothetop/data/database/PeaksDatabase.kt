package com.nebvuu.tothetop.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nebvuu.tothetop.data.entities.Peak

@Database(entities = [Peak::class], version = 1, exportSchema = false)
abstract class PeaksDatabase : RoomDatabase() {

    abstract fun peakDao(): PeakDao

    companion object {

        @Volatile
        private var INSTANCE: PeaksDatabase? = null

        fun getDatabase(context: Context): PeaksDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PeaksDatabase::class.java,
                    "peaks_database.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }


    }

}