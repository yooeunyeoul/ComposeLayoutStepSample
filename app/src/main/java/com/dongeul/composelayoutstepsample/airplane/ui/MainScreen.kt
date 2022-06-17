package com.dongeul.composelayoutstepsample.airplane.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(onExploreItemClicked: OnExploreItemClicked) {
    Surface(color = MaterialTheme.colors.primary) {
        CraneHome(
            onExploreItemClicked = onExploreItemClicked,
            modifier = Modifier
        )
    }
}