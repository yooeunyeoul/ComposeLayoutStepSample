package com.dongeul.composelayoutstepsample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dongeul.composelayoutstepsample.ui.theme.ComposeLayoutStepSampleTheme
import kotlinx.coroutines.launch

@Composable
fun LayoutCodeLab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodeLab")
                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Icon(imageVector = Icons.Filled.Face, contentDescription = "이건 버튼입니다.")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column() {
            PhotographerCard()
            BodyContent(Modifier.padding(innerPadding))

        }

    }

}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = "Hi there"
        )
        Text(
            text = "Thanks for goinng throut the layoutcs codelab"
        )
    }
}

@Preview
@Composable
fun layoutCodelabPreview() {
    ComposeLayoutStepSampleTheme {
        LayoutCodeLab()
    }
}

@Composable
fun SimpleList() {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState, modifier = Modifier.fillMaxSize()) {
        items(100) {
            ImageListItem(index = it)
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(data = "https://developer.android.com/images/brand/Android_Robot.png "),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Item $index", style = MaterialTheme.typography.subtitle1)

    }
}

@Composable
fun ScrollingList() {
    val listSize = 100

    val scrollState = rememberLazyListState()


    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("Scroll to the top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(listSize-1)
                }
            }) {
                Text("Scroll to the end")
            }
        }

        LazyColumn(state = scrollState){
            items(listSize){
                ImageListItem(index = it)
            }
        }

    }
}
