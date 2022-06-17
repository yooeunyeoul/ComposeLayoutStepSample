package com.dongeul.composelayoutstepsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dongeul.composelayoutstepsample.airplane.model.ExploreModel
import com.dongeul.composelayoutstepsample.airplane.ui.MainScreen
import com.dongeul.composelayoutstepsample.airplane.viewmodel.MainViewModel
import com.dongeul.composelayoutstepsample.autoScrolled.sample.model.Feature
import com.dongeul.composelayoutstepsample.autoScrolled.sample.ui.AutoScrollingLazyRow
import com.dongeul.composelayoutstepsample.autoScrolled.sample.ui.FeatureTile
import com.dongeul.composelayoutstepsample.ui.theme.ComposeLayoutStepSampleTheme
import com.dongeul.composelayoutstepsample.wellness.WallnessScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLayoutStepSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(onExploreItemClicked = {

                    })
                }
            }
        }

    }
}



