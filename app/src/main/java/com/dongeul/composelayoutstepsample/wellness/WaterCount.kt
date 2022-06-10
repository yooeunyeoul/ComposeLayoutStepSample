package com.dongeul.composelayoutstepsample.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {

    var count by rememberSaveable {
        mutableStateOf(0)
    }

    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )

}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(
                text = "You' ve had $count glasses",
                modifier = modifier.padding(
                    16.dp
                )
            )
        }

        Button(
            onClick = { onIncrement.invoke() },
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add One")
        }
    }
}