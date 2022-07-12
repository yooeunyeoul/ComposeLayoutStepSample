package com.dongeul.composelayoutstepsample.airplane.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
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
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = Color.Magenta
            )

            Spacer(modifier = Modifier.height(8.dp))

            val listState = rememberLazyListState()

            ExploreList(
                exploreList = exploreList,
                onItemClicked = onItemClicked,
                liststate = listState
            )

        }
    }
}

@Composable
fun ExploreList(
    exploreList: List<ExploreModel>,
    onItemClicked: OnExploreItemClicked /* = (com.dongeul.composelayoutstepsample.airplane.model.ExploreModel) -> kotlin.Unit */,
    modifier: Modifier = Modifier,
    liststate: LazyListState = rememberLazyListState()
) {
    LazyColumn(modifier = modifier, state = liststate) {
        items(exploreList) { exploreItem ->
            Column(Modifier.fillParentMaxWidth()) {
                ExploreItem(
                    modifier = Modifier.fillParentMaxWidth(),
                    item = exploreItem,
                    onItemClicked = onItemClicked
                )
            }

            Divider(color = Color.Red)

        }
    }

}

@Composable
fun ExploreItem(
    modifier: Modifier = Modifier,
    item: ExploreModel,
    onItemClicked: OnExploreItemClicked
) {
    Row(
        modifier = modifier
            .clickable { onItemClicked(item) }
            .padding(
                top = 12.dp,
                bottom = 12.dp
            )
    ) {

        Box {
            SubcomposeAsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data(item.imageUrl)
                .crossfade(true)
                .build(),
                loading = { CircularProgressIndicator()},
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape).fillMaxSize(),
                contentDescription = null)
        }
        Column(modifier = modifier.align(CenterVertically).padding(10.dp)) {
            Text(
                text = item.city.nameToDisplay,
                style = MaterialTheme.typography.h6,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.description,
                style = MaterialTheme.typography.caption.copy(color = Color.DarkGray)
            )
        }

    }

}
