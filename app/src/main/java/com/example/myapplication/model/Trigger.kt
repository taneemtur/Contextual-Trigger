package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "triggers")
data class Trigger (
    @PrimaryKey(autoGenerate = false)
    var id: String = "",
    var trigger: String = ""
)