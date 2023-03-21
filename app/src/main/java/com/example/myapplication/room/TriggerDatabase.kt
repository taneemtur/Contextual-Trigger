package com.example.myapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.Trigger

@Database(entities = [Trigger::class], version = 1, exportSchema = false)
abstract class TriggerDatabase : RoomDatabase() {
    abstract fun TriggerDao(): TriggerDao

    companion object {
        @Volatile
        private var INSTANCE: TriggerDatabase? = null

        fun getInstance(context: Context): TriggerDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TriggerDatabase::class.java,
                        "trigger_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}