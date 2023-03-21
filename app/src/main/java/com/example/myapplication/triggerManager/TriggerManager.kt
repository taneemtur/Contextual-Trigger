package com.example.myapplication.triggerManager


//layer 3

import android.content.Context

import com.example.myapplication.model.Trigger
import com.example.myapplication.room.TriggerDao
import com.example.myapplication.room.TriggerDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TriggerManager(context: Context) {
    private val triggerDao: TriggerDao = TriggerDatabase.getInstance(context).TriggerDao()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)


    val allTriggers = triggerDao.getAll()
    val getTimeTrigger = triggerDao.getTimeTrigger()


    fun addTrigger(newTrigger: Trigger) {
        coroutineScope.launch(Dispatchers.IO) {
            triggerDao.addTrigger(trigger = newTrigger)

        }

    }


}