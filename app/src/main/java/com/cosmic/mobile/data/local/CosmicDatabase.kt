package com.cosmic.mobile.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cosmic.mobile.domain.models.ActionLog
import com.cosmic.mobile.domain.models.Command

@Database(
    entities = [Command::class, ActionLog::class],
    version = 1,
    exportSchema = false
)
abstract class CosmicDatabase : RoomDatabase() {
    abstract fun commandDao(): CommandDao
    abstract fun actionLogDao(): ActionLogDao

    companion object {
        @Volatile
        private var instance: CosmicDatabase? = null

        fun getInstance(context: Context): CosmicDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    CosmicDatabase::class.java,
                    "cosmic_database"
                ).build().also { instance = it }
            }
        }
    }
}
