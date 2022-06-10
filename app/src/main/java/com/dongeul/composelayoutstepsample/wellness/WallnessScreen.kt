package com.dongeul.composelayoutstepsample.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WallnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter(modifier = modifier)
        WellnessTaskList(
            modifier = modifier,
            list = wellnessViewModel.tasks,
            onCloseTask = {task->
                wellnessViewModel.remove(task)
            })
    }
}