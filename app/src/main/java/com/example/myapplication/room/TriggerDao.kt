package com.example.myapplication.room

import androidx.room.Dao
import com.example.myapplication.model.Trigger
import androidx.room.*
import java.util.*

@Dao
interface TriggerDao {
    @Query("SELECT * FROM triggers")
    fun getAll(): List<Trigger>

    @Query("SELECT * FROM triggers WHERE id = time")
    fun getTimeTrigger() : Trigger

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTrigger(trigger: Trigger)

}