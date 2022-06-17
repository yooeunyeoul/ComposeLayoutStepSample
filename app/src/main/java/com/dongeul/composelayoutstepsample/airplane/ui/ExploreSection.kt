package com.dongeul.composelayoutstepsample.airplane.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dongeul.composelayoutstepsample.airplane.model.ExploreModel

@Composable
fun ExploreSection(
    modifier: Modifier = Modifier,
    title: String,
    exploreList: List<ExploreModel>,
    onItemClicked: OnExploreItemClicked
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.padding(
                start = 24.dp, top = 20.dp, end = 24.dp
            )
        ) {
            Text(text = title)

            Spacer(modifier = Modifier.height(8.dp))

            val listState = rememberLazyListState()

        }
    }
}