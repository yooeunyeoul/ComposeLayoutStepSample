package com.dongeul.composelayoutstepsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dongeul.composelayoutstepsample.airplane.ui.CraneHome
import com.dongeul.composelayoutstepsample.shoppingmall.ShoppingMallApp
import com.dongeul.composelayoutstepsample.ui.theme.ComposeLayoutStepSampleTheme
import com.dongeul.composelayoutstepsample.ui.theme.pretendard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var state by remember {
                mutableStateOf(true)
            }

            ComposeLayoutStepSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CraneHome(onExploreItemClicked = {})
                }

            }
        }
    }
}







