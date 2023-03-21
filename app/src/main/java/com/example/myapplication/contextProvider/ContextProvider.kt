package com.example.myapplication.contextProvider

import android.content.Context
import com.example.myapplication.model.Trigger
import com.example.myapplication.triggerManager.TriggerManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// layer 2
class ContextProvider(context: Context)  {

    private var manager = TriggerManager(context);
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val triggers = manager.allTriggers

    fun addTrigger(trigger: Trigger) {
        coroutineScope.launch(Dispatchers.IO) {
            manager.addTrigger(trigger);
        }
    }
    
}