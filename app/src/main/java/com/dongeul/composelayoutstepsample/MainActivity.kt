package com.dongeul.composelayoutstepsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dongeul.composelayoutstepsample.ui.theme.ComposeLayoutStepSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutStepSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Surface(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            LayoutCodeLab()
                        }

                    }

                }
            }
        }
    }
}


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
    ) {innerPadding->
        Column() {
            PhotographerCard()
            BodyContent(Modifier.padding(innerPadding))

        }

    }

}

@Composable
fun BodyContent(modifier: Modifier=Modifier) {
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
