package com.dongeul.composelayoutstepsample.wellness

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.dongeul.composelayoutstepsample.wellness.model.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }
}

fun getWellnessTasks() = List(300) { i -> WellnessTask(id = i, label = "Task # $i") }