package com.dongeul.composelayoutstepsample.autoScrolled.sample.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dongeul.composelayoutstepsample.autoScrolled.sample.model.Feature
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun FeatureTile(feature: Feature) {
    Card(shape = MaterialTheme.shapes.small) {

        Text(
            text = feature.contentDescription,
            style = MaterialTheme.typography.h4,
            fontSize = 50.sp
        )

//        Image(
//            painter = painterResource(
//                id = feature.iconResource
//            ),
//            contentDescription = feature.contentDescription
//        )
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun FeatureList(
    list: List<Feature>,
    modifier: Modifier,
) {
    var itemsListState by remember { mutableStateOf(list) }
    val lazyListState = rememberLazyListState()

    LazyRow(
        state = lazyListState,
        modifier = modifier,
    ) {
        items(itemsListState) {
            FeatureTile(feature = it)
            Spacer(modifier = Modifier.width(1.dp))

            if (it == itemsListState.last()) {
                val currentList = itemsListState

                val secondPart = currentList.subList(0, lazyListState.firstVisibleItemIndex)
                val firstPart =
                    currentList.subList(lazyListState.firstVisibleItemIndex, currentList.size)

                rememberCoroutineScope().launch {
                    lazyListState.scrollToItem(
                        0,
                        maxOf(0, lazyListState.firstVisibleItemScrollOffset - 1)
                    )
                }

                itemsListState = firstPart + secondPart
            }
        }
    }
    LaunchedEffect(Unit) {
        autoScroll(lazyListState, 1f, 1000)
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun <T : Any> AutoScrollingLazyRow(
    list: List<T>,
    modifier: Modifier = Modifier,
    scrollDx: Float = SCROLL_DX,
    delayBetweenScrollMs: Long = DELAY_BETWEEN_SCROLL_MS,
    divider: @Composable () -> Unit = { Spacer(modifier = Modifier.width(1.dp)) },
    itemContent: @Composable (item: T) -> Unit,
) {
    var itemsListState by remember { mutableStateOf(list) }
    val lazyListState = rememberLazyListState()

    LazyRow(
        state = lazyListState,
        modifier = modifier,
    ) {
        items(itemsListState) {
            itemContent(item = it)
            divider()

            if (it == itemsListState.last()) {
                val currentList = itemsListState

                val secondPart = currentList.subList(0, lazyListState.firstVisibleItemIndex)
                val firstPart =
                    currentList.subList(lazyListState.firstVisibleItemIndex, currentList.size)

                rememberCoroutineScope().launch {
                    lazyListState.scrollToItem(
                        0,
                        maxOf(0, lazyListState.firstVisibleItemScrollOffset - scrollDx.toInt())
                    )
                }

                itemsListState = firstPart + secondPart
            }
        }

    }
    LaunchedEffect(Unit) {
        autoScroll(lazyListState, scrollDx, delayBetweenScrollMs)
    }
}

private tailrec suspend fun autoScroll(
    lazyListState: LazyListState,
    scrollDx: Float,
    delayBetweenScrollMs: Long,
) {
    lazyListState.scroll(MutatePriority.PreventUserInput) {
        scrollBy(scrollDx)
    }
    delay(delayBetweenScrollMs)

    autoScroll(lazyListState, scrollDx, delayBetweenScrollMs)
}

private const val DELAY_BETWEEN_SCROLL_MS = 8L
private const val SCROLL_DX = 1f

